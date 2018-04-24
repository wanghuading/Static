package com.sz.learn.factory.func;

import com.sz.learn.factory.Audi;
import com.sz.learn.factory.Car;

/**
 * @Author whd
 * @Date 2018/4/23 21:47
 * @Description
 **/
public class AudiFactory implements FuncFactory {
    @Override
    public Car getInstance() {
        return new Audi();
    }
}
