package com.sz.rxjava2.myrxjava2;


public interface MyObservableSource<T> {
	void subscribe(MyObserver<? super T> observer);
}
