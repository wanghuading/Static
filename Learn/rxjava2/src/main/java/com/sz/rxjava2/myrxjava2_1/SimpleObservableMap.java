package com.sz.rxjava2.myrxjava2_1;

public class SimpleObservableMap<T, R> extends SimpleObservable<R> {
    private SimpleObservableSource<? super T> upstream;
    private SimpleFunction<? super T, ? super R> function;

    public SimpleObservableMap(SimpleObservableSource<? super T> upstream, SimpleFunction<? super T, ? super R> function) {
        this.upstream = upstream;
        this.function = function;
    }

    @Override
    public void subscribeActual(SimpleObserver<? super R> observer) {
        SimpleObservableMap.SimpleMapObserver parent = new SimpleObservableMap.SimpleMapObserver<>(observer, this.function);
        this.upstream.subscribe(parent);
    }

    public static final class SimpleMapObserver<T, R> extends SimpleBaseFuseableObserver<T, R> {
        private SimpleFunction<? super T, ? super R> function;
        SimpleMapObserver(SimpleObserver<? super R> downstream, SimpleFunction<? super T, ? super R> function) {
            super(downstream);
            this.function = function;
        }

        @Override
        public void onNext(T t) {
            System.out.println("map转化");
            Object r = this.function.apply(t);
            this.downstream.onNext(r);
        }
    }
}
