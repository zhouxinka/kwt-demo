package com.zhifou.entity;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 15 10:22
 */
public class ResponseEntity<T> {
    private int code;
    private String msg;
    private T data;

    public static ResponseEntity ok(Object data){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeEnum.OK.getCode());
        responseEntity.setMsg(CodeEnum.OK.getMsg());
        responseEntity.setData(data);
        return responseEntity;
    }

    public static ResponseEntity error(Object msg){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeEnum.ERROR.getCode());
        responseEntity.setMsg((String) msg);
        responseEntity.setData("");
        return responseEntity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String errorMsg) {
        this.msg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
