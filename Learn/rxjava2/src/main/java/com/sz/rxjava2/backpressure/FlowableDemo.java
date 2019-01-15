package com.sz.rxjava2.backpressure;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class FlowableDemo {
    public static void main(String[] args) {
        Flowable.range(1, 5)
                .subscribeOn(Schedulers.newThread())
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        System.out.println("map"+Thread.currentThread().getName());
                        return "map"+integer;
                    }
                })
                .subscribeOn(Schedulers.newThread())
//                .subscribeOn(Schedulers.newThread())
                .subscribe(v -> {
                    computer(v);
                    System.out.println(Thread.currentThread().getName());
                }, Throwable::printStackTrace);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void computer(String v) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(v);
    }
}
