package com.sz.rxjava2.myrxjava2;

public interface MyObservableEmitter<T> extends MyEmitter<T> {
	void setDisposable(MyDisposable var1);
	
	boolean isDisposed();
	
	MyObservableEmitter<T> serialize();
	
	boolean tryOnError(Throwable var1);
}
