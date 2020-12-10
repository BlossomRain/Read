package chapter12.compoundpattern.duck.impl;

import chapter12.compoundpattern.duck.AbstrackDuckFactory;
import chapter12.compoundpattern.duck.Quackable;

public class DuckFactory extends AbstrackDuckFactory {
    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
