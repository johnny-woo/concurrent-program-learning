package com.woo.threadlearn.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3);
        for(int i=0;i<10;i++){
            final int no = i;
            new Thread(()->{
                try {
                    System.out.println("用户"+no+"连接上了");
                    semaphore.acquire();
                    System.out.println("用户"+no+"开始访问程序");
                    Thread.sleep(2000);
                    semaphore.release();
                    System.out.println("用户"+no+"访问结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("Main thread end");
    }
}
