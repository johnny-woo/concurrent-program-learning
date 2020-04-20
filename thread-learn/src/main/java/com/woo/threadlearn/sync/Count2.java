package com.woo.threadlearn.sync;

public class Count2 {

    public int num=0;
    private byte[] lock = new byte[1];

    public synchronized void methodA(){
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName()+"-"+num);
    }

    public void methodB(){
        synchronized (lock){
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num+=1;
            System.out.println(Thread.currentThread().getName()+"-"+num);
        }
    }
}
