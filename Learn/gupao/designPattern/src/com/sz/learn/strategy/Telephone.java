package com.sz.learn.strategy;

/**
 * @Author whd
 * @Date 2018/4/26 22:36
 * @Description
 **/
public class Telephone implements Communication{
    @Override
    public void talk() {
        System.out.println("电话沟通");
    }
}
