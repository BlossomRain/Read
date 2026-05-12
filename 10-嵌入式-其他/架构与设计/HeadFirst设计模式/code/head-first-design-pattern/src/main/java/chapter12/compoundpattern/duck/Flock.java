package chapter12.compoundpattern.duck;

import java.util.ArrayList;

public class Flock implements Quackable {

    private ArrayList<Quackable> quackers;


    public Flock() {

        quackers = new ArrayList<>();
    }

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        for (Quackable quacker : quackers) {
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer ob) {
        for (Quackable quacker : quackers) {
            quacker.registerObserver(ob);
        }

    }

    @Override
    public void notifyObservers() {

    }
}
