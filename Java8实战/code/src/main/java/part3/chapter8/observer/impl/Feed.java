package part3.chapter8.observer.impl;

import part3.chapter8.observer.Observer;
import part3.chapter8.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}