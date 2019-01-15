package com.sz.rxjava2.backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.Scanner;

public class FlowableRequest2 {
	public static void main(String[] args) {
		// 被观察者：一共需要发送500个事件，但真正开始发送事件的前提 = FlowableEmitter.requested()返回值 ≠ 0
// 观察者：每次接收事件数量 = 48（点击按钮）

		final Subscription[] mSubscription = new Subscription[1];
		Flowable.create(new FlowableOnSubscribe<Integer>() {
			@Override
			public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

				System.out.println("观察者可接收事件数量 = " + emitter.requested());
				boolean flag; //设置标记位控制

				// 被观察者一共需要发送500个事件
				for (int i = 0; i < 500; i++) {
					flag = false;

					// 若requested() == 0则不发送
					while (emitter.requested() == 0) {
						if (!flag) {
							System.out.println("不再发送");
							flag = true;
						}
					}
					// requested() ≠ 0 才发送
					System.out.println("发送了事件" + i + "，观察者可接收事件数量 = " + emitter.requested());
					emitter.onNext(i);


				}
			}
		}, BackpressureStrategy.ERROR)
				.subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
				.observeOn(Schedulers.computation()) // 设置观察者在主线程中进行
				.subscribe(new Subscriber<Integer>() {
					@Override
					public void onSubscribe(Subscription s) {
						System.out.println("onSubscribe");
						mSubscription[0] = s;
						s.request(50);
						// 初始状态 = 不接收事件；通过点击按钮接收事件
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


// 点击按钮才会接收事件 = 48 / 次
		try {
			boolean flag = true;
			while (flag) {
				Scanner sc = new Scanner(System.in);
				int req = sc.nextInt();
				if (req > 0) {
					mSubscription[0].request(req);
				} else {
					flag = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
