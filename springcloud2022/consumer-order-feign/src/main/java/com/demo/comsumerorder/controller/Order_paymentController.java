package com.demo.comsumerorder.controller;

import com.demo.entity.CommonResult;
import com.demo.entity.Payment;
import com.demo.service.PaymentClientService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/***
 * 1.@Controller定义控制器类，再使用注解@RequestMapping方法处理请求，完成映射关系。
 * 2.@RestController等价于@Controller加上@ResponseBody
 * 3.@PathVariable获取URI中的变量为参数。
 *
 * 作者：数字d
 * 链接：https://www.jianshu.com/p/a4a7b889a055
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@RestController
@RequestMapping("consumer")
public class Order_paymentController {
    @Resource
    private PaymentClientService paymentClientService;

    @GetMapping("/get/{id}")
     public CommonResult<Payment> selectOne(@PathVariable("id") Integer id){
        return  this.paymentClientService.listById(id);
    }

    @PostMapping( "/create")
     public CommonResult<Integer> create(@RequestBody  Payment payment){
        return this.paymentClientService.create(payment);
    }

}

