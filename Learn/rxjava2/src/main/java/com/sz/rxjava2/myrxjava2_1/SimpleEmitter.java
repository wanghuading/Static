package com.sz.rxjava2.myrxjava2_1;

public interface SimpleEmitter<T> {
	void onSubscribe();
	
	void onNext(T t);
	
	void onError();
	
	void onComplete();
}
