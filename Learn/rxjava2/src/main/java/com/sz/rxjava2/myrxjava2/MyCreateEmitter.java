package com.sz.rxjava2.myrxjava2;

public class MyCreateEmitter<T> implements MyObservableEmitter<T> {
	private MyObserver<? super T> myObserver;
	
	public MyCreateEmitter(MyObserver<? super T> myObserver) {
		this.myObserver = myObserver;
	}
	
	@Override
	public void setDisposable(MyDisposable var1) {
	
	}
	
	@Override
	public boolean isDisposed() {
		return false;
	}
	
	@Override
	public MyObservableEmitter<T> serialize() {
		return null;
	}
	
	@Override
	public boolean tryOnError(Throwable var1) {
		return false;
	}
	
	@Override
	public void onNext(T var1) {
		this.myObserver.onNext(var1);
	}
	
	@Override
	public void onError(Throwable var1) {
	
	}
	
	@Override
	public void onComplete() {
	
	}
	
	@Override
	public void dispose() {
	
	}
}
