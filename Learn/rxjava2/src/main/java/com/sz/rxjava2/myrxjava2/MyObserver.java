package com.sz.rxjava2.myrxjava2;


public interface MyObserver<T>{
	void onSubscribe(MyDisposable var1);

	void onNext(T var1);

	void onError(Throwable var1);

	void onComplete();
}
