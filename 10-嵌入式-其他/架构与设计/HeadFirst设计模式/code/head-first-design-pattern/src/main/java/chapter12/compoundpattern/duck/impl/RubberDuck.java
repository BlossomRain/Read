package chapter12.compoundpattern.duck.impl;

import chapter12.compoundpattern.duck.Observer;
import chapter12.compoundpattern.duck.Quackable;

public class RubberDuck implements Quackable {
    private Observable observable;

    public RubberDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Squeak");
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
