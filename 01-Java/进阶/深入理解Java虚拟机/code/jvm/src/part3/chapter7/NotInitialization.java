package part3.chapter7;


/**
 * 非主动使用类字段演示
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}

/**
 * 被动使用类字段演示二：
 * 通过数组定义来引用类， 不会触发此类的初始化
 **/
class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}

/**
 * 非主动使用类字段演示
 **/
class NotInitialization3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}