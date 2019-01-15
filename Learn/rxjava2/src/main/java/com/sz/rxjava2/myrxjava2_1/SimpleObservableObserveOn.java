package com.sz.rxjava2.myrxjava2_1;

import com.sz.rxjava2.scheduler.SimpleScheduler;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleObservableObserveOn<T> extends SimpleObservable<T> {
    private SimpleObservableSource<? super T> source;
    private SimpleScheduler scheduler;

    public SimpleObservableObserveOn(SimpleObservableSource<? super T> source, SimpleScheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(SimpleObserver<? super T> observer) {
        SimpleScheduler.SimpleWorker worker = this.scheduler.createWorker();
        SimpleObservableObserveOn.SimpleObserverOnObserver parent = new SimpleObservableObserveOn.SimpleObserverOnObserver(observer, worker);
        parent.onSubscribe();
        source.subscribe(parent);
    }

    public class SimpleObserverOnObserver<T> implements SimpleObserver<T>, Runnable {
        private SimpleObserver<? super T> downstream;
        private SimpleScheduler.SimpleWorker worker;

        public SimpleObserverOnObserver(SimpleObserver<? super T> downstream, SimpleScheduler.SimpleWorker worker) {
            this.downstream = downstream;
            this.worker = worker;
        }

        private Queue<T> queue;
        @Override
        public void onSubscribe() {
            queue = new ConcurrentLinkedQueue();
        }

        @Override
        public void onNext(T t) {
            queue.offer(t);
            this.worker.schedule(this);
        }

        @Override
        public void onError() {

        }

        @Override
        public void onComplete() {

        }

        @Override
        public void run() {
            T t = this.queue.poll();
            System.out.println("SimpleObservableObserveOn:"+Thread.currentThread().getName());
            this.downstream.onNext(t);
        }
    }
}
