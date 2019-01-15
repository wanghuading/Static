package com.sz.rxjava2.myrxjava2;


public final class MyObservableCreate<T> extends MyObservable<T> {
	final MyObservableOnSubscribe<T> source;

	public MyObservableCreate(MyObservableOnSubscribe<T> source) {
		this.source = source;
	}

	public void subscribeActual(MyObserver<? super T> observer) {
		MyCreateEmitter<T> parent = new MyCreateEmitter(observer);
		observer.onSubscribe(parent);
		this.source.subscribe(parent);
	}
}
