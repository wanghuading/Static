package com.microservice.springcloudbegin.observer;

public class Test {
    public static void main(String[] args) {
        // 被观察者
        MyObservable observable = new MyObservable();
        // 添加观察者
        observable.addObserver(new Observers());
        observable.addObserver(new Observers());

        // 通知
        observable.setChanged();
        observable.notifyObservers("change");
    }
}
