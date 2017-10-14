package com.jimersylee.springcloud.ribbon.comsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class HelloService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback") // 设置服务不可用时调用的方法
    public String helloService(){
        return restTemplate.getForEntity("http://EUREKA-PROVIDER/dc",String.class).getBody();
    }

    /**
     * 服务降级处理
     * 调用provider服务异常的处理,当出现服务不可用或者服务调用超时(默认1秒)时,调用此接口
     * 如果此方法也有可能出现异常,可以通过注解设置二级降级处理
     * @return
     */
    @HystrixCommand(fallbackMethod = "secondFallback")
    public String helloFallback() throws InterruptedException {
        boolean useful=new Random().nextBoolean();
        if(useful){
            return "server fly away";
        }else{
            //模拟一级降级处理出现异常
            Thread.sleep(3000);
            return "oh,it sucks";
        }

    }

    /**
     * 二级降级处理方法
     * @return
     */
    public String secondFallback(){
        return "the world end";
    }
}
