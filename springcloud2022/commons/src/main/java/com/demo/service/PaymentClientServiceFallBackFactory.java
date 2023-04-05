package com.demo.service;

import com.demo.entity.CommonResult;
import com.demo.entity.Payment;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * FallbackFactory 备选响应 用于处理服务降级问题
 * 千万不要忘记在PaymentClientServiceFallBackFactory 添加注解@Component
 */
@Component //让spring管理
public class PaymentClientServiceFallBackFactory implements FallbackFactory<PaymentClientService> {
    @Override
    public PaymentClientService create(Throwable throwable) {
        return new PaymentClientService() {
            @Override
            public CommonResult listById(Integer id) {
                Payment payment = new Payment();
                payment.setId(id);
                payment.setName("该ID:"+id +"没有对应的信息，Consumer客户端提供的降级信息，此刻的Provider已经关闭");
                payment.setDbSource("no this database in Mysql!");
                return new CommonResult<Payment>(500, "select success", payment);
            }

            @Override
            public CommonResult create(Payment payment) {
                return null;
            }
        };
    }
}
