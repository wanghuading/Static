package com.sz.rxjava2.myrxjava2;

public interface MyEmitter<T> extends MyDisposable {

	void onNext(T var1);

	void onError(Throwable var1);

	void onComplete();
}
