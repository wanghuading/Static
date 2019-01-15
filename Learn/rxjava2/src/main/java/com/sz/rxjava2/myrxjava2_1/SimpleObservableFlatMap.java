package com.sz.rxjava2.myrxjava2_1;

public class SimpleObservableFlatMap<T, R> extends SimpleObservable<T> {
    private SimpleObservable<? super T> observable;
    private final SimpleFunction<? super T, ? extends SimpleObservable<? super R>> function;

    public SimpleObservableFlatMap(SimpleObservable<? super T> observable, SimpleFunction<? super T, ? extends SimpleObservable<? super R>>  function) {
        this.observable = observable;
        this.function = function;
    }

    @Override
    protected void subscribeActual(SimpleObserver observer) {
        SimpleObservableFlatMap.SimpleFlatMapObserver parent = new SimpleObservableFlatMap.SimpleFlatMapObserver<>(observer, this.function);
        this.observable.subscribe(parent);
    }

    public static final class SimpleFlatMapObserver<T, R> extends SimpleBaseFuseableObserver<T, R> {
        private SimpleFunction<? super T, ? extends SimpleObservable<? super R>> function;
        SimpleFlatMapObserver(SimpleObserver<? super R> downstream, SimpleFunction<? super T, ? extends SimpleObservable<? super R>> function) {
            super(downstream);
            this.function = function;
        }

        @Override
        public void onNext(T t) {
            SimpleObservable o = this.function.apply(t);
            o.subscribe(downstream);
        }
    }
}
