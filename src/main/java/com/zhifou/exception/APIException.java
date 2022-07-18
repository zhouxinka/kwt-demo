package com.zhifou.exception;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 18 9:46
 */
public class APIException extends RuntimeException{

    public APIException(String exceptionMsg){
        super(exceptionMsg);

    }

}
