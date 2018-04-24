package com.sz.learn.singleton.register;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author whd
 * @Date 2018/4/24 22:03
 * @Description
 **/
public class RegisterSingletonTest {
    public static void main(String[] args) {
        int count = 200;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);

        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cyclicBarrier.await();
                        Object obj = RegisterSingleton
                                .getInstance("com.sz.learn.singleton.register.RegisterSingleton");
                        System.out.println(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
