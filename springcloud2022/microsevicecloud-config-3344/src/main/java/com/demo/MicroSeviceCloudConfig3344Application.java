package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //开启springcloud-config配置服务
public class MicroSeviceCloudConfig3344Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroSeviceCloudConfig3344Application.class,args);
    }
}
