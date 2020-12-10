package chapter4.factorypattern;

public abstract class Cheese {
    String name;

    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                '}';
    }
}

class NYCheese extends Cheese{
    public NYCheese(){
        name = "NYCheese";
    }
}