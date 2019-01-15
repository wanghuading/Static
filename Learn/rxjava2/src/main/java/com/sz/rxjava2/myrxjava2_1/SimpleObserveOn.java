package com.sz.rxjava2.myrxjava2_1;

import com.sz.rxjava2.scheduler.SimpleScheduler;

public class SimpleObserveOn<T> extends SimpleObservable<T> {
    private SimpleObservableSource<? super T> source;
    private SimpleScheduler scheduler;

    public SimpleObserveOn(SimpleObservableSource<? super T> source,
                           SimpleScheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(SimpleObserver<? super T> observer) {

    }
}
