package com.sz.learn.factory.func;

import com.sz.learn.factory.Benz;
import com.sz.learn.factory.Car;

/**
 * @Author whd
 * @Date 2018/4/23 21:48
 * @Description
 **/
public class FuncFactoryTest {
    public static void main(String[] args) {
        BenzFactory benzFactory = new BenzFactory();
        Car car = benzFactory.getInstance();
        System.out.println(car);
    }
}
