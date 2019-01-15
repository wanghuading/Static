package com.sz.rxjava2.scheduler;

import com.sz.rxjava2.myrxjava2.MyDisposable;

import java.util.concurrent.TimeUnit;

public abstract class SimpleScheduler {
    public abstract MyWorker createWorker();

    public MyDisposable scheduleDirect(Runnable run) {
        return this.scheduleDirect(run, 0L, TimeUnit.NANOSECONDS);
    }

    public MyDisposable scheduleDirect(Runnable run, long delay,
                                       TimeUnit unit) {
        SimpleScheduler.MyWorker w = this.createWorker();
        MyDisposeTask task = new SimpleScheduler.MyDisposeTask(run, w);
        w.schedule(task, delay, unit);
        return task;
    }

    public abstract static class MyWorker {
        public MyDisposable schedule(Runnable run) {
            return this.schedule(run, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract MyDisposable schedule(Runnable var1, long var2,
                                            TimeUnit var4);
    }

    static final class MyDisposeTask implements MyDisposable, Runnable {
        final Runnable decoratedRun;
        final SimpleScheduler.MyWorker w;
        Thread runner;

        MyDisposeTask(Runnable decoratedRun, SimpleScheduler.MyWorker w) {
            this.decoratedRun = decoratedRun;
            this.w = w;
        }

        public void run() {
            this.runner = Thread.currentThread();

            try {
                this.decoratedRun.run();
            } finally {
                this.dispose();
                this.runner = null;
            }

        }


        @Override
        public void dispose() {

        }

        @Override
        public boolean isDisposed() {
            return false;
        }
    }
}
