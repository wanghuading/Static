package com.sz.rxjava2.backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.awt.event.ActionListener;

public class FlowableCreateDemo {
    public static void main(String[] args) {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> flowableEmitter) throws Exception {
                long n = flowableEmitter.requested();
                System.out.println("request num"+n);
                flowableEmitter.onNext("111");
                flowableEmitter.onNext("222");
                flowableEmitter.onNext("333");
            }
        }, BackpressureStrategy.BUFFER).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(1);
            }
    
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
    
            @Override
            public void onError(Throwable throwable) {
        
            }
    
            @Override
            public void onComplete() {
        
            }
        });
    }
}
