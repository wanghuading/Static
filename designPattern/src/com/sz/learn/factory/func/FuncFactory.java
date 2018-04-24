package com.sz.learn.factory.func;

import com.sz.learn.factory.Car;

/**
 * @Author whd
 * @Date 2018/4/23 21:45
 * @Description 工厂方法模式，一个工厂生产一个产品
 **/
public interface FuncFactory {
    public Car getInstance();
}
