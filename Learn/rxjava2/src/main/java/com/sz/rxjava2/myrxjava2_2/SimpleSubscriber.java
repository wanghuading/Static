package com.sz.rxjava2.myrxjava2_2;

public interface SimpleSubscriber<T> {
	void onSubscribe(SimpleFlowSubscription subscription);
	
	void onNext(T t);
	
	void onComplete();
	
	void onError();
}
