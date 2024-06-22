package ch02;

import java.io.Serializable;

public class Singleton implements Serializable {
    private static final long serialVersionUID = 2020121502L;
    public static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
