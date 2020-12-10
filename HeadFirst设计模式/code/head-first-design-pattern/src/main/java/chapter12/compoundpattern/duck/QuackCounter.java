package chapter12.compoundpattern.duck;

import chapter12.compoundpattern.duck.impl.Observable;

public class QuackCounter implements Quackable {

    private Quackable duck;
    private static int count = 0;
    private Observable observable;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
        observable = new Observable(this);
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void quack() {
        duck.quack();
        count++;
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
