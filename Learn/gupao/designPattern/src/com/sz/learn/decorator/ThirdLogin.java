package com.sz.learn.decorator;

import com.sz.learn.adapter.Result;

/**
 * @Author whd
 * @Date 2018/4/29 9:12
 * @Description
 **/
public class ThirdLogin implements IThirdLogin {
    public ILogin login;
    public ThirdLogin(ILogin login){
        login = this.login;
    }
    @Override
    public Result register(String userName, String password) {
        return null;
    }

    @Override
    public Result login(String userName, String password) {
        return null;
    }

    @Override
    public Result loginForQQ(String id) {
        Result result = login.register(id, null);
        result = login.login(id, null);
        return result;
    }
}
