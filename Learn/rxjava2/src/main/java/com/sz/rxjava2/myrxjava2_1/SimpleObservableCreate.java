package com.sz.rxjava2.myrxjava2_1;

public class SimpleObservableCreate<T> extends SimpleObservable<T> {
	private SimpleObservableOnSubscribe<T> source;
	public SimpleObservableCreate(SimpleObservableOnSubscribe<T> source) {
		this.source = source;
	}
	
	
	@Override
	protected void subscribeActual(SimpleObserver<? super T> observer) {
		SimpleEmitterCreate<T> parent = new SimpleEmitterCreate(observer);
		observer.onSubscribe();
		source.subscribe(parent);
	}
}
