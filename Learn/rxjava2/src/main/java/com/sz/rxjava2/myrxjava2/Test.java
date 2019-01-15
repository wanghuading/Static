package com.sz.rxjava2.myrxjava2;

public class Test {
	public static void main(String[] args) {
		MyObservable.create(new MyObservableOnSubscribe<String>() {
			@Override
			public void subscribe(MyEmitter<String> var1) {
				var1.onNext("sssss");
			}
		}).subscribe(new MyObserver<String>() {
			@Override
			public void onSubscribe(MyDisposable var1) {
			
			}

			@Override
			public void onNext(String var1) {
				System.out.println(var1);
			}

			@Override
			public void onError(Throwable var1) {

			}

			@Override
			public void onComplete() {

			}
		});
	}
}
