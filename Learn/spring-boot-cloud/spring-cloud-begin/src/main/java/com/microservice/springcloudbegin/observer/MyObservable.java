package com.microservice.springcloudbegin.observer;

import java.util.Observable;

public class MyObservable extends Observable {
    public synchronized void setChanged() {
        super.setChanged();
    }
}
