package ch02;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.testSigleton();
    }

    void testSigleton() throws Exception {
        Singleton s1 = null;
        Singleton s = Singleton.INSTANCE;

        FileOutputStream fos = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (Singleton) ois.readObject();

        System.out.println(s == s1);
    }

    void testPizza() {
        Pizza pizza = new NYPizza.Builder(NYPizza.Size.SMALL)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.ONION)
                .build();
    }
}

