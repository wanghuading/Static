package com.sz.rxjava2.myrxjava2_2;

import com.sz.rxjava2.myrxjava2_1.SimpleObservableOnSubscribe;

public abstract class SimpleFlowable<T> implements SimplePublisher<T> {
	public static <T> SimpleFlowable create(SimpleFlowableOnSubscribe<? super T> source) {
		return new SimpleFlowCreate(source);
	}
	
	@Override
	public void subscribe(SimpleSubscriber<? super T> subscriber) {
		this.subscribeActual(subscriber);
	}
	
	protected abstract void subscribeActual(SimpleSubscriber<? super T> subscriber);
}
