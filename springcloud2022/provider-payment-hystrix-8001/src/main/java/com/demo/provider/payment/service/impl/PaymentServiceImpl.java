package com.demo.provider.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.entity.Payment;
import com.demo.provider.payment.dao.PaymentDao;
import com.demo.provider.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("paymentService")
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, Payment> implements PaymentService{
    @Resource
    private PaymentDao paymentDao;
    @Override
    public Payment listById(Integer id) {
        return paymentDao.selectById(id);
    }

    @Override
    public Integer create(Payment payment) {
        return paymentDao.insert(payment);
    }
}
