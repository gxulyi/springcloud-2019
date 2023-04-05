package com.demo.comsumerorder.controller;

import com.demo.entity.CommonResult;
import com.demo.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8011";
    //消费端通过微服务端名字去访问 微服务
   public static final String PAYMENT_URL = "http://PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
    //测试@EnableDiscoveryClient，消费端可以调用服务发现
    @GetMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery/" , Object.class);
    }
}

