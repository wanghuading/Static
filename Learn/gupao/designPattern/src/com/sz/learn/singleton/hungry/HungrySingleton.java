package com.sz.learn.singleton.hungry;

/**
 * @Author whd
 * @Date 2018/4/24 18:00
 * @Description 饿汉式单例
 **/
public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
