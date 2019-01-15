package com.sz.rxjava2.backpressure;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class FlowableDemo2 {
    public static void main(String[] args) {
//        Flowable<Integer> o = Flowable.just(computeValue());
        Flowable<Integer> o = Flowable.fromCallable(() -> computeValue());

        o.subscribe(System.out::println);
        o.subscribe(System.out::println);


    }

    public static int counter;

    public static int computeValue() {
        return ++counter;
    }

}
