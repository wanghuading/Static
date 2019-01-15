package com.sz.rxjava2.myrxjava2_1;

public interface SimpleObservableSource<T> {
	void subscribe(SimpleObserver<? super T> observer);
}
