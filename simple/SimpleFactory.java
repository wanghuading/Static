package com.sz.learn.factory.simple;

import com.sz.learn.factory.Audi;
import com.sz.learn.factory.BMW;
import com.sz.learn.factory.Benz;
import com.sz.learn.factory.Car;

/**
  * @Author whd
  * @Date 2018/4/23 21:17
  * @Description 简单工厂模式，根据条件生成相应的产品，即实例
  **/
public class SimpleFactory {
    /**
      * @Author whd
      * @Date 2018/4/23 21:17
      * @Param [name]
      * @Return com.sz.learn.factory.Car
      * @Description
      **/
    public Car createCar(String name) {
        if ("Benz".equals(name)) {
            return new Benz();
        } else if ("Audi".equals(name)) {
            return new Audi();
        } else if ("BMW".equals(name)) {
            return new BMW();
        } else {
            System.out.println("不能生产您所需的产品");
            return null;
        }
    }
}
