package com.demo.provider.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.Payment;


public interface PaymentService extends IService<Payment> {


  
    Payment listById(Integer id);


    Integer create(Payment payment);

}
