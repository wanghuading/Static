package com.sz.learn.factory.abstr;

import com.sz.learn.factory.Car;

/**
 * @Author whd
 * @Date 2018/4/24 9:02
 * @Description
 **/
public class AbstrFactoryTest {
    public static void main(String[] args) {
        AbstrFactory abstrFactory = new AbstrFactoryImpl();
        Car car = abstrFactory.getAudi();
        System.out.println(car);
    }
}
