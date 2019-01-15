package com.sz.rxjava2.backpressure;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

public class FlowableDemo1 {
    public static void main(String[] args) {
        Flowable.range(1, 1_000_000)
                .subscribe(new DisposableSubscriber<Integer>() {
                    @Override
                    public void onStart() {
                        request(1);
                    }

                    public void onNext(Integer v) {
                        compute(v);

                        request(1);
                    }

                    @Override
                    public void onError(Throwable ex) {
                        ex.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });
    }

    private static void compute(Integer v) {
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(v);
    }
}
