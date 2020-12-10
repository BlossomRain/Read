package chapter12.compoundpattern.duck.impl;

import chapter12.compoundpattern.duck.Observer;
import chapter12.compoundpattern.duck.QuackObservable;

import java.util.ArrayList;


public class Observable implements QuackObservable {

    ArrayList<Observer> observers = new ArrayList();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }
    }
}
