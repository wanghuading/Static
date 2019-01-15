package com.sz.rxjava2.myrxjava2_2;

public interface SimpleFlowSubscription<T> {
	void request(long var1);
	
	void cancel();
}
