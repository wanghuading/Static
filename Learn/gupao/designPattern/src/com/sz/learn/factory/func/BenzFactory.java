package com.sz.learn.factory.func;

import com.sz.learn.factory.Benz;
import com.sz.learn.factory.Car;

/**
 * @Author whd
 * @Date 2018/4/23 21:46
 * @Description
 **/
public class BenzFactory implements FuncFactory {
    @Override
    public Car getInstance() {
        return new Benz();
    }
}
