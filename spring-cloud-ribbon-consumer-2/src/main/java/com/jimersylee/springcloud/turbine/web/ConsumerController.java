package com.jimersylee.springcloud.turbine.web;

import com.jimersylee.springcloud.turbine.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HelloService helloService;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        return helloService.helloService();
    }
}
