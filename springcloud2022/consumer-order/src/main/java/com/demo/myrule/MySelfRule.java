package com.demo.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //return new RandomRule() ; //默认轮询，我们自定义后使用随机
         // return new RoundRobinRule() ; //轮询
        return new  RandomRule_ZY();//自定义的算法
    }
}
