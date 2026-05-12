package chapter12.compoundpattern;

import chapter12.compoundpattern.duck.Observer;
import chapter12.compoundpattern.duck.QuackObservable;

public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist :" + duck +" just quacked...");
    }
}
