package com.sz.rxjava2.myrxjava2_2;

public interface SimpleFlowableOnSubscribe<T> {
	void subscribe(SimpleFlowEmitter<? super T> emitter);
}
