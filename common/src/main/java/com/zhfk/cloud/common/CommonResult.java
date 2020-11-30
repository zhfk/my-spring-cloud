package com.zhfk.cloud.common;

public class CommonResult {

    public int code = 20000;
    public String message = "操作成功";
    private Object data = null;

    public CommonResult() {
    }

    public CommonResult(String message) {
        this.message = message;
    }

    public CommonResult(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public CommonResult(Object data) {
        this.data = data;
    }

    public CommonResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
