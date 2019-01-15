package com.sz.rxjava2.myrxjava2_2;

import com.sz.rxjava2.myrxjava2_1.SimpleEmitter;
import com.sz.rxjava2.myrxjava2_1.SimpleObservableOnSubscribe;

import java.util.concurrent.atomic.AtomicLong;

public class SimpleFlowCreate<T> extends SimpleFlowable<T> {
	private SimpleFlowableOnSubscribe<T> source;
	
	public SimpleFlowCreate(SimpleFlowableOnSubscribe<T> source) {
		this.source = source;
	}
	
	@Override
	protected void subscribeActual(SimpleSubscriber<? super T> subscriber) {
		SimpleFlowCreate.SimpleBaseEmitter<T> baseEmitter = null;
		baseEmitter = new SimpleMissingEmitter<T>(subscriber);
		subscriber.onSubscribe((SimpleFlowSubscription) baseEmitter);
		source.subscribe(baseEmitter);
	}
	
	static class SimpleBaseEmitter<T> extends AtomicLong implements SimpleFlowEmitter<T>, SimpleFlowSubscription {
		protected SimpleSubscriber subscriber;
		
		public SimpleBaseEmitter(SimpleSubscriber subscriber) {
			this.subscriber = subscriber;
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
		
		@Override
		public void request(long var1) {
			this.compareAndSet(0, 1);
		}
		
		@Override
		public void cancel() {
		
		}
	}
	
	static class SimpleMissingEmitter<T> extends SimpleBaseEmitter<T> {
		
		public SimpleMissingEmitter(SimpleSubscriber subscriber) {
			super(subscriber);
		}
		
		@Override
		public void onNext(T t) {
			if (!this.isCancelled()) {
				if (t == null) {
					System.out.println("error null");
				} else {
					if (this.get() > 0) {
						this.subscriber.onNext(t);
					}
					
					long r;
					do {
						r = this.get();
					} while(r != 0L && !this.compareAndSet(r, r - 1L));
					
				}
			}
		}
	}
}
