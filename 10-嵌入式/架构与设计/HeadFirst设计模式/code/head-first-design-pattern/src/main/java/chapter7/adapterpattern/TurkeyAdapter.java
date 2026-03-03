package chapter7.adapterpattern;

public class TurkeyAdapter implements Duck {

    Turkey turkey ;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quark() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
