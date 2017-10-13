package com.jimersylee.springcloud.ribbon.comsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        return restTemplate.getForEntity("http://EUREKA-PROVIDER/dc",String.class).getBody();
    }

    /**
     * 调用provider服务异常的处理,当出现服务不可用或者服务调用超时(默认2秒)时,调用此接口
     * @return
     */
    public String helloFallback(){
        return "server fly away";
    }
}
