package com.zhifou.entity;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 15 10:18
 */
public enum CodeEnum {
    OK(200,"请求成功"),
    ERROR(500,"请求失败");

    private int code;
    private String message;

    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
