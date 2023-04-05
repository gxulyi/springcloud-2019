package com.demo.comsumerorder;

import com.demo.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
/**
 * /在启动该微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
 * //MySelfRule 自定义的Ribbon配置类不能放在@ComponentScan所扫描的当前包以及子包下，
 * 否则我们这个自定义的这个配置类就会被所有的ribbon客户端所共享，达不到特殊化定制的目的
 * @RibbonClient(name = "PROVIDER-PAYMENT",configuration = MySelfRule.class)
 */

@RibbonClient(name = "PROVIDER-PAYMENT",configuration = MySelfRule.class)
public class ConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class,args);
    }
}

