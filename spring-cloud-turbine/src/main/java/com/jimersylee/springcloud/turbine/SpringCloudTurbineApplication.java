package com.jimersylee.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * turbine,多应用监控
 */
@SpringBootApplication
@EnableDiscoveryClient // 通过此注解让该应用注册为Eureka客户端应用
@EnableTurbine // 通过此注解开启Turbine

// 或者可以使用@SpringCloudApplication注解来修改应用主类,该注解包括了上述3个注解,意味着SpringCloud标准应用包含服务发现与断路器
public class SpringCloudTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTurbineApplication.class, args);
    }

}
