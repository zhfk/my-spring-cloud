package com.zhfk.cloud.common;

import lombok.ToString;

@ToString
public class CommonResult<T> {

    public int code = 20000;
    public String message = "操作成功";
    private T data = null;

    public CommonResult() {
    }

    public CommonResult(String message) {
        this.message = message;
    }

    public CommonResult(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public CommonResult(T data) {
        this.data = data;
    }

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
