package com.jimersylee.springcloudeureka.web;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
public class DcController {
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        //String service = "Service: " + discoveryClient.getServices();

        //模拟服务出现延迟,因为熔断机制默认2000毫秒
        int sleepTime=new Random().nextInt(2000);
        //int sleepTime=100;
        Thread.sleep(sleepTime);
        String service="hello world from provider 2";
        System.out.println(service);
        System.out.println("delayTime:"+sleepTime);
        return service;
    }
}
