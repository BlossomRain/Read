package chapter4;

public class Father {
    {
        System.out.println("父类代码块");
    }

    static {
        System.out.println("父类静态代码块");
    }

    public Father() {
        System.out.println("父类构造器");
    }

    public void method(){
        System.out.println("father method");
    }
}
