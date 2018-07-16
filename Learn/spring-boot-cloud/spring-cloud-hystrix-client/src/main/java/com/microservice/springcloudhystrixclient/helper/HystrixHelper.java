package com.microservice.springcloudhystrixclient.helper;

import org.springframework.scheduling.annotation.Scheduled;
import rx.Observer;
import rx.Single;
import rx.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.*;

public class HystrixHelper {

    public static void main(String[] args) {
        Random random = new Random();
        reactiveX(random);
    }

    public static void reactiveX(Random random) {
        Single.just("test")
                .subscribeOn(Schedulers.immediate())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("发生异常");
                    }

                    @Override
                    public void onNext(String s) {
                        // 如果随机时间 大于 100 ，那么触发容错
                        int value = random.nextInt(200);

                        if (value > 100) {
                            throw new RuntimeException("Timeout!");
                        }

                        System.out.println("helloWorld() costs " + value + " ms.");
                    }
                });
    }

    public static void futureTest(Random random) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int randomVal = random.nextInt(200);
                try {
                    System.out.println("randomVal = " + randomVal);
                    Thread.sleep(randomVal);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "success";
            }
        });

        try {
            future.get(100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("超时保护");
        }

        executorService.shutdownNow();
    }
}
