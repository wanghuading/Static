package com.sz.learn.adapter;

/**
 * @Author whd
 * @Date 2018/4/29 7:33
 * @Description
 **/
public class Login {
    public Result register(String userName, String password) {
        return new Result(200, "注册成功");
    }


    public Result login(String userName, String password) {
        return new Result(200, "登录成功");
    }
}
