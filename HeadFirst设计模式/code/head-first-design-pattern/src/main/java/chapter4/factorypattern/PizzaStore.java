package chapter4.factorypattern;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.doSomething();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
