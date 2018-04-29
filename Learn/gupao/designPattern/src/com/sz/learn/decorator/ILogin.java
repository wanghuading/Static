package com.sz.learn.decorator;

import com.sz.learn.adapter.Result;

/**
 * @Author whd
 * @Date 2018/4/29 9:09
 * @Description
 **/
public interface ILogin {
    public Result register(String userName, String password);

    public Result login(String userName, String password);
}
