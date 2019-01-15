package com.sz.rxjava2.myrxjava2_2;

public class SimpleFlowableTest {
	public static void main(String[] args) {
		SimpleFlowable.create(new SimpleFlowableOnSubscribe<String>() {
			@Override
			public void subscribe(SimpleFlowEmitter<? super String> emitter) {
				emitter.onNext("1111");
				emitter.onNext("2222");
			}
		}).subscribe(new SimpleSubscriber<String>() {
			@Override
			public void onSubscribe(SimpleFlowSubscription subscription) {
				subscription.request(1);
			}
			
			@Override
			public void onNext(String s) {
				System.out.println("onNext:"+s);
			}
			
			@Override
			public void onComplete() {
			
			}
			
			@Override
			public void onError() {
			
			}
		});
	}
}
