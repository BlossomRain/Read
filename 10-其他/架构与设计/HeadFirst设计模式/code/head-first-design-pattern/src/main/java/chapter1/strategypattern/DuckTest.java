package chapter1.strategypattern;

public class DuckTest {
    public static void main(String[] args) {
        Duck duck = new ModelDuck();
        duck.performFly();
        duck.performQuack();

        duck.setFly(new FlyRocketPowered());
        duck.performFly();
    }
}
