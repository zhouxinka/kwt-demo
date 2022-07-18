package com.zhifou.advice;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zhifou.entity.ResponseEntity;
import com.zhifou.exception.APIException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 15 14:36
 */
@RestControllerAdvice(basePackages = {"com.zhifou.controller"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {
    static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
                    throws IOException, JsonProcessingException {
                arg1.writeString("");
            }
        });
    }
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println("Controller方法是："+methodParameter.getMethod().getName());
        System.out.println("Controller方法的返回值参数类型是："+methodParameter.getParameterType().getName());
        //如果返回类型不是ResponseEntity就执行下面的beforeBodyWrite方法，对返回值进行二次处理
        return !methodParameter.getParameterType().isAssignableFrom(ResponseEntity.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        System.out.println("Controller方法的返回值是" + data);
        // String类型不能直接包装
        if (returnType.getGenericParameterType().equals(String.class)) {
            try {
                // 将数据包装在ResponseEntity里后转换为json串进行返回
                return objectMapper.writeValueAsString(ResponseEntity.ok(data));
            } catch (JsonProcessingException e) {
                throw new APIException(e.getMessage());
            }
        }
        return ResponseEntity.ok(data);
    }

}
