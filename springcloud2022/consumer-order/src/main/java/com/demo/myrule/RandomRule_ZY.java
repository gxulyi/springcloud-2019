package com.demo.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

import java.util.List;
import java.util.Random;

public class RandomRule_ZY extends AbstractLoadBalancerRule {
    private int total = 0 ;//总共被调用的次数 ,每台服务要求被调用5次
    private int currentIndex = 0 ;//当前服务提供的机器号
   // Random rand;

    public Server choose(ILoadBalancer lb,Object obj){
        if(lb == null){
            return null ;
        }
        Server server = null ;
        while(server == null){
            if(Thread.interrupted()){
                return null ;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers() ;
            int countSize = allList.size();
            if(countSize == 0){
                return null ;
            }
//            int index = rand.nextInt(countSize);
//            server = upList.get(index);
            if(total < 5){
                server = upList.get(currentIndex);
                System.out.println("是否调用成功？？？？？？？？"+currentIndex);
                total++ ;
            }else{
                total = 0;
                currentIndex ++;
                if(currentIndex >= upList.size()){
                    currentIndex = 0;
                }
            }

            if(server == null){
                Thread.yield();
                continue;
            }
            if(server.isAlive()){
                return (server) ;
            }
            server = null ;
            Thread.yield();

        }
        return server;
    }
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose( Object o) {

        return choose(getLoadBalancer(),o);
    }
}
