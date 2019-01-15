package com.sz.rxjava2.myrxjava2_1;

import com.sz.rxjava2.scheduler.SimpleScheduler;

public abstract class SimpleObservable<T> implements SimpleObservableSource<T> {
	private SimpleObserver<? super T> observer;
	
	public static <T> SimpleObservable create(SimpleObservableOnSubscribe<T> observableOnSubscribe) {
		return new SimpleObservableCreate(observableOnSubscribe);
	}

	public <R> SimpleObservable<R> map(SimpleFunction<? super T, ? super R> function) {
		return new SimpleObservableMap<T, R>(this, function);
	}

	public <R> SimpleObservable<R> flatMap(SimpleFunction<? super T, ? extends SimpleObservable<? super R>> function) {
		return new SimpleObservableFlatMap(this, function);
	}

	public SimpleObservable<T> SimpleSubscribeOn(SimpleScheduler scheduler) {
		return new SimpleObservableSubscribeOn(this, scheduler);
	}

	public SimpleObservable<T> SimpleObserverOn(SimpleScheduler scheduler) {
		return new SimpleObservableObserveOn<T>(this, scheduler);
	}
	
	@Override
	public void subscribe(SimpleObserver<? super T> observer) {
		subscribeActual(observer);
	}
	
	protected abstract void subscribeActual(SimpleObserver<? super T> observer);
}
