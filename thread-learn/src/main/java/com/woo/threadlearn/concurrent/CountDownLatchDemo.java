package com.woo.threadlearn.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    static class Worker extends Thread{
        private String workerName;
        private CountDownLatch countDownLatch;

        public Worker(String workerName,CountDownLatch countDownLatch){
            this.workerName = workerName;
            this.countDownLatch = countDownLatch;
        }

        public void run(){
            try {
                System.out.println("Worker:"+workerName+"start");
                Thread.sleep(2000);
                System.out.println("Worker:"+workerName+"end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Worker worker1 = new Worker("工人1",countDownLatch);
        Worker worker2 = new Worker("工人2",countDownLatch);
        Worker worker3 = new Worker("工人3",countDownLatch);
        worker1.start();
        worker2.start();
        worker3.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread end");
    }
}
