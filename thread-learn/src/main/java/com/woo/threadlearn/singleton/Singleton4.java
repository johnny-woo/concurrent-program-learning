package com.woo.threadlearn.singleton;

import java.util.concurrent.locks.ReentrantLock;

public class Singleton4 {

    private static Singleton4 instance;
    private static ReentrantLock lock1 = new ReentrantLock();

    public static Singleton4 getInstance(){
        if (instance == null) {
            lock1.lock();
            if(instance==null) {
                instance = new Singleton4();
            }
            lock1.unlock();
        }
        return instance;
    }
}
