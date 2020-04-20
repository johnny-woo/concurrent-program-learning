package com.woo.threadlearn.lock;

public class DeadlockDemo {

    private byte[] lock1 = new byte[1];
    private byte[] lock2 = new byte[1];

    public void add1(){
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+"lock1 add1 start");
            try {
                Thread.sleep(1000);
                synchronized (lock2){
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock1 add1 end");
        }
    }

    public void add2(){
        synchronized (lock2){
            try {
                System.out.println(Thread.currentThread().getName()+"add2 lock2 start");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"add2 lock2 end");
        }
    }

    public static void main(String[] arg){
        DeadlockDemo demo = new DeadlockDemo();
        new Thread(()->demo.add1()).start();
        new Thread(()->demo.add2()).start();
    }
}
