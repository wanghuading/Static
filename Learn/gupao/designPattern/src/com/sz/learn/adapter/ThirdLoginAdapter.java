package com.sz.learn.adapter;

/**
 * @Author whd
 * @Date 2018/4/29 7:38
 * @Description 适配器模式
 **/
public class ThirdLoginAdapter extends Login {
    public Result loginForQQ(String id) {

        return super.login(id, null);
    }

    public Result registerForQQ(String id) {
        Result result = super.register(id, null);
        return super.login(id, null);
    }
}
