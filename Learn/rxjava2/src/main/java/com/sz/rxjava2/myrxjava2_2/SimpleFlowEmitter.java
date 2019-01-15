package com.sz.rxjava2.myrxjava2_2;

public interface SimpleFlowEmitter<T> {
	void dispose();
	
	boolean isDisposed();
	
	void onSubscribe(SimpleFlowSubscription subscription);
	
	void onNext(T t);
	
	void onError();
	
	void onComplete();
	
	boolean isCancelled();
}
