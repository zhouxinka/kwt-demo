package com.zhifou.advice;

import com.zhifou.entity.ResponseEntity;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 15 14:36
 */
@ControllerAdvice(basePackages = {"com.zhifou.controller"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        //System.out.println("Controller方法是："+methodParameter.getMethod().getName());
        //System.out.println("Controller方法的返回值参数类型是："+methodParameter.getParameterType().getName());
        //如果返回类型不是ResponseEntity就只从下面的beforeBodyWrite方法，对返回值进行二次处理
        return !methodParameter.getParameterType().isAssignableFrom(ResponseEntity.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        System.out.println("Controller方法的返回值是"+data);
        return ResponseEntity.ok(data);
    }
}
