package chapter12.compoundpattern.duck;

public abstract class AbstrackDuckFactory {

    public abstract Quackable createDuckCall();

    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedHeadDuck();

    public abstract Quackable createRubberDuck();
}
