package com.life.learn;

public class Singleton {

    private Singleton(){}

    private static Singleton singleton = null;

    public static  Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
