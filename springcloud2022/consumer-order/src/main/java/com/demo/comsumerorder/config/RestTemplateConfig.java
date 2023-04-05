package com.demo.comsumerorder.config;

import com.demo.comsumerorder.interceptor.MyInterceptor;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Configruation注解修饰的类，会被spring通过cglib做增强处理，通过cglib会生成一个代理对象，代理会拦截所有被@Bean注解
//修饰的方法，可以确保这些bean是单例的

@Configuration
public class RestTemplateConfig {

    //不管是@Bean所在的类是否有@Configruation注解，都可以将@Bean修饰的方法作为一个bean注册到spring容器中
    @Bean
    @LoadBalanced //开启客户端的负载均衡 因为spring cloud ribbon 是基于netflix Ribbon实现的的一套客户端 负载均衡工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    public IRule myRule(){
       // return new RoundRobinRule();//轮询算法
        //return new RandomRule() ;//目的:用我们重新选择的随机算法替代默认的轮询算法
        return new RetryRule();//目的 ：先按照RoundRobinRule策略获取服务，若获取服务失败则在指定时间内会进行重试服务获取，获取可用服务
    }
    /***
     * 创建 RestTemplate 时需要一个 ClientHttpRequestFactory，通过这个请求工厂，我们可以统一设置请求的超时时间，
     * 设置代理以及一些其他细节。通过上面代码配置后，我们直接在代码中注入 RestTemplate 就可以使用了。
     * @param factory
     * @return
     */
//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        RestTemplate restTemplate = new RestTemplate(factory);
//        MyInterceptor myInterceptor = new MyInterceptor();
//        List<ClientHttpRequestInterceptor> list = new ArrayList<>();
//        list.add(myInterceptor);
//        restTemplate.setInterceptors(list);
//        return restTemplate;
//    }

//    @Bean
//    public RestTemplate restTemplates(ClientHttpRequestFactory factory) {
//        RestTemplate restTemplate = new RestTemplate(factory);
//        return restTemplate;
//    }
//
//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(5000);
//        factory.setConnectTimeout(15000);
//        // 设置代理
//        //factory.setProxy(null);
//        return factory;
//
//    }
//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        RestTemplate restTemplate = new RestTemplate(factory);
//        MyResponseErrorHandler errorHandler = new MyResponseErrorHandler();
//        restTemplate.setErrorHandler(errorHandler);
//        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
//        // 通过下面代码可以添加新的 HttpMessageConverter
//        //messageConverters.add(new );
//        return restTemplate;
//    }
}

