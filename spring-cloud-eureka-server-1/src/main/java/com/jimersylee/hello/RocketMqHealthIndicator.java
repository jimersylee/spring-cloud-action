package com.jimersylee.hello;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


/**
 * RocketMQ健康监控器
 * @author jimersylee
 */
@Component
public class RocketMqHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode=this.check();
        if(errorCode!=0){
            return Health.down().withDetail("Error Code",errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        //对监控对象的检测操作

        return 0;
    }
}
