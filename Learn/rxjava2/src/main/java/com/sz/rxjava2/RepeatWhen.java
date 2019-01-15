package com.sz.rxjava2;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class RepeatWhen {
    public static void main(String[] args) {
        Observable.range(0, 9)
        .subscribeOn(Schedulers.io())
        /*.repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                return Observable.timer(10, TimeUnit.SECONDS);
            }
        })*/.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
        try {
            Thread.sleep(12000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
