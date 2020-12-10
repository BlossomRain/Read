package chapter4.factorypattern;

public class PizzaTest {

    public static void main(String[] args){
        PizzaStore store = new NYPizzaStore();
        store.orderPizza("cheese");
    }
}
