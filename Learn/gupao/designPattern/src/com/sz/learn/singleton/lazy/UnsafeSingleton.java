package com.sz.learn.singleton.lazy;

/**
 * @Author whd
 * @Date 2018/4/24 18:04
 * @Description 饿汉式单例：非线程安全
 **/
public class UnsafeSingleton {
    private static UnsafeSingleton INSTANCE = null;

    public static UnsafeSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UnsafeSingleton();
        }
        return INSTANCE;
    }
}
