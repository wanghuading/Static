package com.sz.learn.singleton.lazy;

/**
 * @Author whd
 * @Date 2018/4/24 18:12
 * @Description 使用内部类实现线程安全的单例
 **/
public class InnerSingleton {

//    private static boolean inital = false;

    /**
  * @Author whd
  * @Date 2018/4/24 18:31
  * @Param []
  * @Return
  * @Description 私有化构造方法，防止暴力反射，导致单例被破坏，即会产生多个实例
  **/
    private InnerSingleton() {
        synchronized(InnerSingleton.class) {
            if (!Inner.inital) {
                Inner.inital = !Inner.inital;
            } else {
                throw new RuntimeException("单例已被侵入");
            }
        }
    }


    public static final InnerSingleton getInstance() {
        return Inner.INSTANCE;
    }


    private static class Inner {
        private static boolean inital = false;
        private static final InnerSingleton INSTANCE = new InnerSingleton();
    }
}
