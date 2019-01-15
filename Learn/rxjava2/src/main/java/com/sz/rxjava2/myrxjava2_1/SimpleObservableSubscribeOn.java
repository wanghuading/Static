package com.sz.rxjava2.myrxjava2_1;

import com.sz.rxjava2.scheduler.SimpleScheduler;

public class SimpleObservableSubscribeOn<T> extends SimpleObservable<T> {
    public SimpleObservableSource<? super T> source;
    private SimpleScheduler scheduler;

    public SimpleObservableSubscribeOn(SimpleObservableSource<? super T> source, SimpleScheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(SimpleObserver<? super T> observer) {
        SimpleObservableSubscribeOn.SimpleObservableSubscribeOnObserver parent = new SimpleObservableSubscribeOn.SimpleObservableSubscribeOnObserver(observer, scheduler);
        scheduler.scheduleDirect(new Runnable() {
            @Override
            public void run() {
                source.subscribe(parent);
            }
        });
    }

    public class SimpleObservableSubscribeOnObserver<T> extends SimpleBaseFuseableObserver<T, T> {
        private SimpleScheduler scheduler;

        public SimpleObservableSubscribeOnObserver(SimpleObserver<? super T> downstream, SimpleScheduler scheduler) {
            super(downstream);
            this.scheduler = scheduler;
        }

        @Override
        public void onNext(T t) {
            System.out.println("CurrentThread:"+Thread.currentThread().getName());
            downstream.onNext(t);
        }
    }
}
