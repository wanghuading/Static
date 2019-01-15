package com.sz.rxjava2.myrxjava2_1;

public abstract class SimpleBaseFuseableObserver<T, R> implements SimpleObserver<T> {
    protected SimpleObserver downstream;
    SimpleBaseFuseableObserver(SimpleObserver<? super R> downstream) {
        this.downstream = downstream;
    }

    @Override
    public void onError() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe() {

    }
}
