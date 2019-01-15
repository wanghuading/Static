package com.sz.rxjava2;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HelloWorld {
    public static void main(String[] args) {

        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("Hello, World");
            }
        })
        .map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return "map"+s;
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.newThread())
        .flatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Exception {

                return Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                        observableEmitter.onNext("pp");
                        observableEmitter.onNext(s);
                    }
                });
            }
        })
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                System.out.println(s);
            }
        });
    }
}
