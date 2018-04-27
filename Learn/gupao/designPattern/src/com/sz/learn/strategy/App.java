package com.sz.learn.strategy;

/**
 * @Author whd
 * @Date 2018/4/26 22:37
 * @Description
 **/
public class App implements Communication {
    @Override
    public void talk() {
        System.out.println("使用微信、QQ交流");
    }
}
