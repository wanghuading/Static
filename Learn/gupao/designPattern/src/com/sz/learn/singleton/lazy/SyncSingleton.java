package com.sz.learn.singleton.lazy;

/**
 * @Author whd
 * @Date 2018/4/24 18:13
 * @Description 使用synchronize实现线程安全的单例
 **/
public class SyncSingleton {
    private static SyncSingleton INSTANCE = null;

    private synchronized static SyncSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SyncSingleton();
        }
        return INSTANCE;
    }
}
