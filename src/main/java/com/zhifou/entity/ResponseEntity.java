package com.zhifou.entity;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 15 10:22
 */
public class ResponseEntity {
    private int code;
    private String message;
    private Object data;

    public static ResponseEntity ok(Object data){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeEnum.OK.getCode());
        responseEntity.setMessage(CodeEnum.OK.getMessage());
        responseEntity.setData(data);
        return responseEntity;
    }

    public static ResponseEntity error(Object data){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeEnum.ERROR.getCode());
        responseEntity.setMessage(CodeEnum.ERROR.getMessage());
        responseEntity.setData(data);
        return responseEntity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
