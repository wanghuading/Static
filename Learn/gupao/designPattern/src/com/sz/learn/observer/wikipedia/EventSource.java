package com.sz.learn.observer.wikipedia;

import java.util.Observable;
import java.util.Scanner;

public class EventSource extends Observable implements Runnable {
    @Override
    public void run() {
        while (true) {
            String reponse = new Scanner(System.in).next();
            setChanged();
            notifyObservers(reponse);
        }
    }
}
