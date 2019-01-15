package com.sz.rxjava2.backpressure;

import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;

public class PublishProcessorDemo {
    public static void main(String[] args) throws InterruptedException {
        PublishProcessor<Integer> publishProcessor = PublishProcessor.create();
        publishProcessor.observeOn(Schedulers.computation())
                .subscribe(v -> computer(v), Throwable::printStackTrace);
        for (int i = 0; i < 129; i++) {
            publishProcessor.onNext(i);
        }
        Thread.sleep(100_000);
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
