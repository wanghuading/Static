package com.sz.learn.singleton.register;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author whd
 * @Date 2018/4/24 21:52
 * @Description 注册式单例
 **/
public class RegisterSingleton {
    private static ConcurrentHashMap<String, Object> INSTANCES = new ConcurrentHashMap<>();

    private RegisterSingleton(){}

    public synchronized static Object getInstance(String className) {
        try {
            if (!INSTANCES.containsKey(className)) {
                Class clazz = Class.forName(className);
                Object obj = clazz.newInstance();
                INSTANCES.putIfAbsent(className, obj);
                return obj;
            } else {
                return INSTANCES.get(className);
            }
        } catch (Exception e) {
            System.out.println("取得该单例失败");
        }
        return null;
    }
}
