package com.sz.rxjava2;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Join {
    public static void main(String[] args) {
        AtomicInteger index = new AtomicInteger(1);
        Observable o1 = Observable.interval(1, TimeUnit.SECONDS, Schedulers.computation());
        Observable o2 = Observable.interval(2, TimeUnit.SECONDS, Schedulers.computation());
        o1.join(o2, new Function<Long, ObservableSource>() {
            @Override
            public ObservableSource apply(Long integer) throws Exception {
                System.out.println("source" + integer);
                return Observable.just(String.valueOf(integer)).delay(2, TimeUnit.SECONDS);
            }
        }, new Function<Long, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Long integer) throws Exception {
                System.out.println("target:"+integer);
                return Observable.just(String.valueOf(integer));
            }
        }, new BiFunction<Long, Long, String>() {
            @Override
            public String apply(Long integer, Long integer2) throws Exception {
                return integer + ":" + integer2;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("onNext:" + s);
            }
        });


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
