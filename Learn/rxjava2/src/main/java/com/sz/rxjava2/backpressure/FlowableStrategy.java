package com.sz.rxjava2.backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class FlowableStrategy {
	public static void main(String[] args) {
		// 创建被观察者Flowable
		Flowable.create(new FlowableOnSubscribe<Integer>() {
			@Override
			public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

				// 发送 129个事件
				for (int i = 0;i< 140; i++) {
					System.out.println("发送了事件" + i);
					emitter.onNext(i);
				}
				emitter.onComplete();
			}
		}, BackpressureStrategy.MISSING) // 设置背压模式 = BackpressureStrategy.ERROR
				.subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
				.observeOn(Schedulers.newThread()) // 设置观察者在主线程中进行
				.subscribe(new Subscriber<Integer>() {
					@Override
					public void onSubscribe(Subscription s) {
						System.out.println("onSubscribe");
					}

					@Override
					public void onNext(Integer integer) {
						System.out.println("接收到了事件" + integer);
					}

					@Override
					public void onError(Throwable t) {
						System.out.println("onError: ");
					}

					@Override
					public void onComplete() {
						System.out.println("onComplete");
					}
				});
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
