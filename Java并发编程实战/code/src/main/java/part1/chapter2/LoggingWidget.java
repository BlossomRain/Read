package part1.chapter2;

/**
 * 假如 sync 是不可重入锁,就会发生死锁
 * 1. LoggingWidget 对象执行 doSomething 方法,获取this所对象(widget)
 * 2. 调用父类doSomething ,要获取锁,锁又是this即widget,那么就发生死锁了
 */


public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomething() {
        System.out.println(this);
        super.doSomething();
    }

    public static void main(String[] args) {
        LoggingWidget widget = new LoggingWidget();
        widget.doSomething();
    }


}
