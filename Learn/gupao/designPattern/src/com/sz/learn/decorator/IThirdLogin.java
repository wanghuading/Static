package com.sz.learn.decorator;

import com.sz.learn.adapter.Result;

/**
 * @Author whd
 * @Date 2018/4/29 9:12
 * @Description
 **/
public interface IThirdLogin extends ILogin {
    public Result loginForQQ(String id);
}
