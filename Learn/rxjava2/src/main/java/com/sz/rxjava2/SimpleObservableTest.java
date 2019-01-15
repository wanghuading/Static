package com.sz.rxjava2;

import com.sz.rxjava2.myrxjava2_1.SimpleFunction;
import com.sz.rxjava2.myrxjava2_1.SimpleObservable;
import com.sz.rxjava2.myrxjava2_1.SimpleObservableOnSubscribe;
import com.sz.rxjava2.myrxjava2_1.SimpleObserver;
import com.sz.rxjava2.myrxjava2_2.SimpleFlowEmitter;
import com.sz.rxjava2.scheduler.SimpleNewThreadScheduler;

public class SimpleObservableTest {
	public static void main(String[] args) {
		SimpleObservable.create(new SimpleObservableOnSubscribe<String>() {
			@Override
			public void subscribe(SimpleFlowEmitter<String> emitter) {
				emitter.onNext("111");
			}
		}).map(new SimpleFunction<String, Integer>() {
			@Override
			public Integer apply(String var1) {
				return Integer.valueOf(var1);
			}
		})
		.SimpleSubscribeOn(new SimpleNewThreadScheduler())
		.flatMap(new SimpleFunction<Integer, SimpleObservable>() {
			@Override
			public SimpleObservable apply(Integer var1) {
				return SimpleObservable.create(new SimpleObservableOnSubscribe<Integer>() {
					@Override
					public void subscribe(SimpleFlowEmitter<Integer> emitter) {
						emitter.onNext(222);
						emitter.onNext(var1);
					}
				});
			}
		})
		.subscribe(new SimpleObserver<Integer>() {
			@Override
			public void onSubscribe() {

			}

			@Override
			public void onNext(Integer integer) {
				System.out.println(integer);
			}

			@Override
			public void onError() {

			}

			@Override
			public void onComplete() {

			}
		});

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
