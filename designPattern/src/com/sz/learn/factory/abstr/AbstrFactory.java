package com.sz.learn.factory.abstr;

import com.sz.learn.factory.Car;

/**
 * @Author whd
 * @Date 2018/4/24 8:54
 * @Description 抽象工厂模式，一个工厂有多个流水线，一个流水线对应一个产品
 **/
public abstract class AbstrFactory {
    protected abstract Car getAudi();
    protected abstract Car getBenz();
    protected abstract Car getBMW();
}
