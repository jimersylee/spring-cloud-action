package com.jimersylee.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon消费者
 */
@SpringBootApplication
@EnableDiscoveryClient // 通过此注解让该应用注册为Eureka客户端应用
@EnableCircuitBreaker // 通过此注解让该应用开启断路器功能

// 或者可以使用@SpringCloudApplication注解来修改应用主类,该注解包括了上述3个注解,意味着SpringCloud标准应用包含服务发现与断路器
public class SpringCloudRibbonConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonConsumerApplication.class, args);
    }

    /**
     * 创建RestTemplate的Spring Bean实例,并通过@LoadBalanced注解开启客户端负载均衡
     *
     * @return RestTemplate实例
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
