package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ConsumerZuulGetWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZuulGetWayApplication.class, args);

    }
}
