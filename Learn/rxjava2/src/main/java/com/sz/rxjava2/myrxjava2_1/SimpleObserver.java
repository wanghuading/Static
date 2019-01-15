package com.sz.rxjava2.myrxjava2_1;

public interface SimpleObserver<T> {
	void onSubscribe();
	
	void onNext(T t);
	
	void onError();
	
	void onComplete();
}
