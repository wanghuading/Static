package com.sz.learn.factory.simple;

import com.sz.learn.factory.Car;

/**
 * @Author whd
 * @Date 2018/4/23 21:20
 * @Description
 **/
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory sf = new SimpleFactory();
        Car car = sf.createCar("ll");
        System.out.println(car);
    }
}
