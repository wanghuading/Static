package com.sz.learn.adapter;

/**
 * @Author whd
 * @Date 2018/4/29 7:33
 * @Description
 **/
public class Result {
    private int code;
    private String msg;

    public Result () {

    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
