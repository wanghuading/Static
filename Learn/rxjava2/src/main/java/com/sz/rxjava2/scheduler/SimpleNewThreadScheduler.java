package com.sz.rxjava2.scheduler;

import io.reactivex.internal.schedulers.RxThreadFactory;

import java.util.concurrent.ThreadFactory;

public class SimpleNewThreadScheduler extends SimpleScheduler {
    final ThreadFactory threadFactory;
    private static final RxThreadFactory THREAD_FACTORY;
    public SimpleNewThreadScheduler() {
        this(THREAD_FACTORY);
    }

    public SimpleNewThreadScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    @Override
    public MyWorker createWorker() {
        return new SimpleNewThreadWorker(this.threadFactory);
    }

    static {
        int priority = Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5)));
        THREAD_FACTORY = new RxThreadFactory("MyRxNewThreadScheduler", priority);
    }
}
