package part1.chapter2;

public class Widget {
    public synchronized void doSomething() {
        System.out.println(this);
    }
}