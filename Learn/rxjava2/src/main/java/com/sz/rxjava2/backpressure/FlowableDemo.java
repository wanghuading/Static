package com.sz.rxjava2.backpressure;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class FlowableDemo {
    public static void main(String[] args) {
        Flowable.range(1, 1_000_000)
                .observeOn(Schedulers.computation())
                .subscribe(v -> computer(v), Throwable::printStackTrace);

        try {
            Thread.sleep(100_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void computer(Integer v) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(v);
    }
}
