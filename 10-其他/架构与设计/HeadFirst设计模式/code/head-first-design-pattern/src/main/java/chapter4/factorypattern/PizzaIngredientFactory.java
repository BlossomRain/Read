package chapter4.factorypattern;

public interface PizzaIngredientFactory {
    Cheese createCheese();
    //...
    // create more ingredients
}
