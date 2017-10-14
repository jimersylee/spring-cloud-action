package com.jimersylee.springcloudeureka.web;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DcController {
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        //String service = "Service: " + discoveryClient.getServices();
        String service="hello world from provider 1";
        System.out.println(service);
        return service;
    }
}
