package com.demo.provider.payment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

}
