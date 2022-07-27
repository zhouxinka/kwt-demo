package com.zhifou.advice;

import com.zhifou.entity.ResponseEntity;
import com.zhifou.exception.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 15 15:30
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)//无论发送什么异常，http的状态码必须返回200,由业务码去区分系统的异常情况
    @ResponseBody
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("参数校验失败,");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(",");
        }
        String msg = sb.toString();
        return ResponseEntity.error(msg.substring(0,msg.lastIndexOf(",")));
    }

    @ExceptionHandler({APIException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity handleMyException(APIException apiException) {
        return ResponseEntity.error(apiException.getMessage());
    }
    //处理其他（以上两种以外）的异常
    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity handleUnknownException(Exception e) {
        System.out.println("发生了其他异常");
        return ResponseEntity.error(e.toString());
    }
}
