package chapter4.factorypattern;

public class NYPizzaStore extends PizzaStore implements PizzaIngredientFactory {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("cheese")) pizza = new NYCheesePizza();

        return pizza;
    }

    @Override
    public Cheese createCheese() {
        return new NYCheese();
    }
}
