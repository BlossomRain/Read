package chapter1.strategypattern;

public interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("FlyWithWings.........");
    }
}

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly......");
    }
}
class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Fly Rocket Powered........");
    }
}