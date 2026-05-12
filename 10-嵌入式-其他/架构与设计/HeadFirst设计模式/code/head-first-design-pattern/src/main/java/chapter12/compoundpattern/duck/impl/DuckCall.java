package chapter12.compoundpattern.duck.impl;

import chapter12.compoundpattern.duck.Observer;
import chapter12.compoundpattern.duck.Quackable;

public class DuckCall implements Quackable {
    private Observable observable;

    public DuckCall() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Kwak");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer ob) {
        observable.registerObserver(ob);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
