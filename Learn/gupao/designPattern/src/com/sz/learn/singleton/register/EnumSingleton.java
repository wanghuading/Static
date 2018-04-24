package com.sz.learn.singleton.register;

/**
 * @Author whd
 * @Date 2018/4/24 22:52
 * @Description 枚举可以看做单例一种
 **/
public enum  EnumSingleton {
    RED() {
        private int g = 0;
    }
}
