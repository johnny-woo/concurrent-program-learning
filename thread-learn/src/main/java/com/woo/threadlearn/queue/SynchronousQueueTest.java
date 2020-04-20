package com.woo.threadlearn.queue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

    public static void main(String[] arg){
        System.out.println("begin:"+System.currentTimeMillis()/1000);
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        Semaphore semaphore = new Semaphore(1);
        for(int i=0;i<10;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    String input = synchronousQueue.take();
                    String output = TestDo.doSome(input);
                    System.out.println(Thread.currentThread().getName()+":"+output);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for(int i=0;i<10;i++){
            String input = i+"";
            try {
                synchronousQueue.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
