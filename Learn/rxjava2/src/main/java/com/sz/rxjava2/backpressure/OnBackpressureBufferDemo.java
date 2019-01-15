package com.sz.rxjava2.backpressure;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class OnBackpressureBufferDemo {
	public static void main(String[] args) {
		/*Flowable.range(1, 1_000)
				.onBackpressureBuffer()
				.observeOn(Schedulers.computation(), false, 8)
				.subscribe(e -> {
					System.out.println(e);
				}, Throwable::printStackTrace);*/
		Flowable.range(1, 1000)
//				.onBackpressureBuffer(16, () -> {}, BackpressureOverflowStrategy.DROP_LATEST)
				.onBackpressureLatest()
				.observeOn(Schedulers.computation(), false, 8)
				.subscribe(e -> {
					System.out.println(e);
				}, Throwable::printStackTrace);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
