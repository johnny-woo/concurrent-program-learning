package com.woo.threadlearn.thread;

public class ThreadA extends Thread {
    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("这是线程A");

        for(int i=0;i<10000;i++){
            System.out.println("后台线程A第"+i+"次执行");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
