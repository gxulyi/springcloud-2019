package com.demo.provider.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 * EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND
 * HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
 * eureka  ---eureka自我保护机制
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册到eureka服务中
@EnableDiscoveryClient //服务发现
public class ProviderPaymentApplication {//启动类
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentApplication.class,args);
    }
}

