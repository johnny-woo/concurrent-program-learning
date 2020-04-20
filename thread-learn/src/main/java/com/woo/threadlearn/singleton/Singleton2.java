package com.woo.threadlearn.singleton;

public class Singleton2 {

    private static Singleton2 instance;

    public synchronized static Singleton2 getInstance(){
        if(instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}
