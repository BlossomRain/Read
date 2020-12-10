package chapter4;

public class Son extends Father {
    {
        System.out.println("子类代码块");
    }

    static {
        System.out.println("子类静态代码块");
    }

    public Son() {
        System.out.println("子类构造器");
    }

    public void sunMethod(){
        System.out.println("son method");
    }
}
