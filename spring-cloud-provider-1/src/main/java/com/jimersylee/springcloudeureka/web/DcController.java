package com.jimersylee.springcloudeureka.web;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试服务提供者
 * @author jimersylee
 */
@RestController
public class DcController {

    @GetMapping("/dc")
    public String dc() {

        String service="hello world from provider 1";
        System.out.println(service);
        return service;
    }
}
