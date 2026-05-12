package chapter4.factorypattern;

public class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        name = "pepperoni pizza";
    }

    @Override
    public void doSomething() {
        System.out.println(name + " do work");
    }
}
