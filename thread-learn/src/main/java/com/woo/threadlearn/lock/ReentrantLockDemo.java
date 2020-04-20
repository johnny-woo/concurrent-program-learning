package com.woo.threadlearn.lock;

import com.woo.threadlearn.sync.Count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockDemo {
    // 创建一个ReentrantReadWriteLock对象
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    // 抽取读锁和写锁
    private Lock readLock = rwl.readLock();
    private Lock writeLock = rwl.writeLock();

    public void get(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"read start.");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"read end");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }

    public void put(){
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "write start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"write end");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] arg){
//        Count ct = new Count();
//        for(int i=0;i<2;i++){
//            new Thread(()-> ct.get()).start();
//        }
//        for(int i=0;i<2;i++){
//            new Thread(()->ct.put()).start();
//        }

        ReentrantLockDemo demo = new ReentrantLockDemo();
        for(int i=0;i<2;i++){
            new Thread(()->demo.get()).start();
        }
        for(int i=0;i<2;i++){
            new Thread(()->demo.put()).start();
        }
    }
}
