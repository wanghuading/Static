package com.sz.rxjava2.myrxjava2_1;

import com.sz.rxjava2.myrxjava2_2.SimpleFlowEmitter;
import com.sz.rxjava2.myrxjava2_2.SimpleFlowSubscription;

public class SimpleEmitterCreate<T> implements SimpleDisposable, SimpleFlowEmitter<T> {
	private SimpleObserver<? super T> observer;
	
	public SimpleEmitterCreate(SimpleObserver<? super T> observer) {
		this.observer = observer;
	}
	
	@Override
	public void dispose() {
	
	}
	
	@Override
	public boolean isDisposed() {
		return false;
	}
	
	@Override
	public void onSubscribe(SimpleFlowSubscription subscription) {
	
	}
	
	@Override
	public void onNext(T t) {
		this.observer.onNext(t);
	}
	
	@Override
	public void onError() {
	
	}
	
	@Override
	public void onComplete() {
	
	}
	
	@Override
	public boolean isCancelled() {
		return false;
	}
}
