package com.zhifou.entity;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 15 10:18
 */
public enum CodeEnum {
    OK(200,"success"),
    ERROR(500,"fail");

    private int code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "CodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
