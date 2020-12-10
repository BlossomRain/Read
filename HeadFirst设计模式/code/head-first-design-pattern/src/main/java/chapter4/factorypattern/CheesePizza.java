package chapter4.factorypattern;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "cheese pizza";
    }

    @Override
    public void doSomething() {
        System.out.println(name + "do work");
    }
}

class NYCheesePizza extends CheesePizza{
    public NYCheesePizza() {
        name = "NY cheese pizza";
    }
}