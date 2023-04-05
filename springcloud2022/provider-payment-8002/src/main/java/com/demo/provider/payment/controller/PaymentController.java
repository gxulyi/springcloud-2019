package com.demo.provider.payment.controller;

import com.demo.entity.CommonResult;
import com.demo.entity.Payment;
import com.demo.provider.payment.service.PaymentService;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Integer id) {
        Payment payment = this.paymentService.listById(id);
        return new CommonResult<Payment>(200, "select success", payment);
    }


    @PostMapping("create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        Integer insert = this.paymentService.create(payment);
        System.out.println("打印输出"+insert);
        return new CommonResult<>(200, "insert success", insert);
    }
    //服务发现
    @RequestMapping(value="/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("打印服务"+list);
        List<ServiceInstance> instances  = discoveryClient.getInstances( "PROVIDER-PAYMENT");
        for (ServiceInstance element : instances){
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" +
                    element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }
}

