package com.woo.threadlearn.sync;

import java.util.concurrent.locks.ReentrantLock;

public class Count {

    public int num = 0;
    ReentrantLock lock = new ReentrantLock();

    public synchronized void methodA(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName()+"-"+num);
    }

    public void methodB(){
        synchronized (this){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num+=1;
            System.out.println(Thread.currentThread().getName()+"-"+num);
        }
    }

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" get begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" get end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void put(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" put begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" put end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
