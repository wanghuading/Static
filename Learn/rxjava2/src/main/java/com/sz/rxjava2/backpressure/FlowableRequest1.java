package com.sz.rxjava2.backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class FlowableRequest1 {
	public static void main(String[] args) {
		Flowable.create(new FlowableOnSubscribe<Integer>() {
			@Override
			public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

				// 调用emitter.requested()获取当前观察者需要接收的事件数量
				long n = emitter.requested();

				System.out.println( "观察者可接收事件" + n);

				// 根据emitter.requested()的值，即当前观察者需要接收的事件数量来发送事件
				for (int i = 0; i < n; i++) {
					System.out.println( "发送了事件" + i);
					emitter.onNext(i);
				}
			}
		}, BackpressureStrategy.ERROR)
				.subscribe(new Subscriber<Integer>() {
					@Override
					public void onSubscribe(Subscription s) {
						System.out.println( "onSubscribe");

						// 设置观察者每次能接受10个事件
						s.request(10);

					}

					@Override
					public void onNext(Integer integer) {
						System.out.println( "接收到了事件" + integer);
					}

					@Override
					public void onError(Throwable t) {
						System.out.println( "onError: ");
					}

					@Override
					public void onComplete() {
						System.out.println( "onComplete");
					}
				});
	}
}
