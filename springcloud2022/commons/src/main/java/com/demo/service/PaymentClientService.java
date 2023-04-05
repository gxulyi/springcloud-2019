package com.demo.service;

import com.demo.entity.CommonResult;
import com.demo.entity.Payment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
//@Component //spring管理
//@FeignClient(value = "PROVIDER-PAYMENT")
@FeignClient(value = "PROVIDER-PAYMENT", fallbackFactory = PaymentClientServiceFallBackFactory.class)
public interface PaymentClientService {
    /**
     * /**
     *      * 声明一个feign的接口，它的实现是服务提供者的controller实现
     */
    /**
     * 接口方法声明要求：需要和被调用的服务的controller方法声明保持一致
     * public CommonResult<Payment> selectOne(@PathVariable("id") Integer id) {
     */
   @GetMapping("/payment/get/{id}")

   CommonResult listById(@PathVariable("id") Integer id);

    @PostMapping("/payment/create")
    CommonResult create(@RequestBody Payment payment);
}
