package com.woo.threadlearn.singleton;

public class Singleton3 {

    private static Singleton3 instance;
    private static byte[] lock1 = new byte[1];

    public static Singleton3 getInstance(){
        if (instance == null) {
            synchronized(lock1) {
                if(instance==null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
