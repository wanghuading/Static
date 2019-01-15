package com.sz.rxjava2.myrxjava2_1;

import com.sz.rxjava2.myrxjava2_2.SimpleFlowEmitter;

public interface SimpleObservableOnSubscribe<T> {
	void subscribe(SimpleFlowEmitter<T> emitter);
}
