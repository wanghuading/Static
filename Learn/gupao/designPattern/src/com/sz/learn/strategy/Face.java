package com.sz.learn.strategy;

/**
 * @Author whd
 * @Date 2018/4/26 22:35
 * @Description
 **/
public class Face implements Communication {
    @Override
    public void talk() {
        System.out.println("我们当面聊");
    }
}
