package com.sz.rxjava2.scheduler;

import com.sz.rxjava2.myrxjava2.MyDisposable;
import com.sz.rxjava2.scheduler.SimpleScheduler.SimpleWorker;

import java.util.concurrent.*;

public class SimpleNewThreadWorker extends SimpleWorker implements MyDisposable {
    private final ScheduledExecutorService executor;

    public SimpleNewThreadWorker(ThreadFactory factory) {
        this.executor = Executors.newScheduledThreadPool(5, factory);
    }

    @Override
    public MyDisposable schedule(Runnable var1, long var2, TimeUnit var4) {
        return this.scheduleActual(var1, 0L, (TimeUnit)null);
    }

    public MyDisposable scheduleActual(Runnable run, long delayTime,
             TimeUnit unit) {
        try {
            Object f;
            if (delayTime <= 0L) {
                f = this.executor.submit(run);
            } else {
                f = this.executor.schedule(run, delayTime, unit);
            }

        } catch (Exception var10) {

        }

        return null;
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean isDisposed() {
        return false;
    }
}
