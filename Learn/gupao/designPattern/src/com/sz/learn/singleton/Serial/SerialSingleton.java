package com.sz.learn.singleton.Serial;

import java.io.Serializable;

/**
 * @Author whd
 * @Date 2018/4/24 19:25
 * @Description
 **/
public class SerialSingleton implements Serializable {
    private static final SerialSingleton INSTANCE = new SerialSingleton();

    private SerialSingleton() {}

    public static SerialSingleton getInstance() {
        return INSTANCE;
    }

    /**
      * @Author whd
      * @Date 2018/4/24 21:50
      * @Param []
      * @Return java.lang.Object
      * @Description 反序列化时，返回单例对象，避免创建新对象，破坏单例原则
      **/
    private Object readResolve() {
        return INSTANCE;
    }

}
