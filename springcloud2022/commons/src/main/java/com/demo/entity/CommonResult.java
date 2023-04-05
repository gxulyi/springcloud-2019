package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*省掉 get set */
@Data
/*全参数构造器*/
@AllArgsConstructor
/*无参构造器（空参构造器）*/
@NoArgsConstructor
public class CommonResult<T> {
    /*404 not found*/
    private Integer code;
    /*消息：success failure*/
    private String message;
    /*数据*/
    private T data;
    public static CommonResult success(){
        CommonResult result=new CommonResult();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    public static <T> CommonResult<T> success(T data){
        CommonResult<T> result=new CommonResult<T>();
        result.setData(data);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }
    public static CommonResult error(Integer code,String msg) {
        CommonResult result = new CommonResult();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
    public CommonResult(Integer code, String message) {
       this(code, message,null);
    }

}

