package com.sz.rxjava2.myrxjava2;



public abstract class MyObservable<T> implements MyObservableSource<T>{

	public static <T> MyObservable<T> create(MyObservableOnSubscribe<T> source) {
		return new MyObservableCreate(source);
	}

	public final void subscribe(MyObserver<? super T> observer) {
		this.subscribeActual(observer);
	}

	protected abstract void subscribeActual(MyObserver<? super T> var1);



}
