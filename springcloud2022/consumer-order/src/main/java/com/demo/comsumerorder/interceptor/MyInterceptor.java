package com.demo.comsumerorder.interceptor;

import jdk.internal.instrumentation.Logger;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
@Slf4j

//public class MyInterceptor implements ClientHttpRequestInterceptor {
public class MyInterceptor{
//    @Override
//    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        log.info("统一拦截处理");
//        return execution.execute(request,body);
//    }
}
