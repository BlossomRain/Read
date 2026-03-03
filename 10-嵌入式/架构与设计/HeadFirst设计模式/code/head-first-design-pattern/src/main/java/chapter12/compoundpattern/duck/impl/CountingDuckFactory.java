package chapter12.compoundpattern.duck.impl;

import chapter12.compoundpattern.duck.AbstrackDuckFactory;
import chapter12.compoundpattern.duck.QuackCounter;
import chapter12.compoundpattern.duck.Quackable;

public class CountingDuckFactory extends AbstrackDuckFactory {
    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounter(new RedHeadDuck());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
