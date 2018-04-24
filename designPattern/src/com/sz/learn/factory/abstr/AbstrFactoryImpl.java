package com.sz.learn.factory.abstr;

import com.sz.learn.factory.Audi;
import com.sz.learn.factory.BMW;
import com.sz.learn.factory.Benz;
import com.sz.learn.factory.Car;

/**
 * @Author whd
 * @Date 2018/4/24 8:59
 * @Description
 **/
public class AbstrFactoryImpl extends AbstrFactory {
    @Override
    protected Car getAudi() {
        return new Audi();
    }

    @Override
    protected Car getBenz() {
        return new Benz();
    }

    @Override
    protected Car getBMW() {
        return new BMW();
    }
}
