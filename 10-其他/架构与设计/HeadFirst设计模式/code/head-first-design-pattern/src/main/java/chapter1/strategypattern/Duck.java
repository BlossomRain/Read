package chapter1.strategypattern;

public abstract class Duck {
    private FlyBehavior fly;
    private QuackBehavior quack;

    public void setFly(FlyBehavior fly) {
        this.fly = fly;
    }

    public void setQuack(QuackBehavior quack) {
        this.quack = quack;
    }

    public Duck() {
    }

    public Duck(FlyBehavior fly, QuackBehavior quack) {
        this.fly = fly;
        this.quack = quack;
    }

    public void performFly() {
        fly.fly();
    }

    public void performQuack() {
        quack.quack();
    }
}

class MallarDuck extends Duck {
    public MallarDuck() {
        super(new FlyWithWings(),new Quack());
    }
}

class ModelDuck extends Duck{
    public ModelDuck(){
        super(new FlyNoWay(),new MuteQuack());
    }
}