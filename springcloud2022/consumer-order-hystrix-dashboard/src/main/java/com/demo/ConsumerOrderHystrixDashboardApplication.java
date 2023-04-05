package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启hystrix以及hystrixboard相关配置
public class ConsumerOrderHystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderHystrixDashboardApplication.class,args);

    }
}
