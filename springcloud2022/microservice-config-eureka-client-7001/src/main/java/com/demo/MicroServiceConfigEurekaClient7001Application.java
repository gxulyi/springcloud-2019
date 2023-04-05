package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceConfigEurekaClient7001Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConfigEurekaClient7001Application.class , args);
    }
}
