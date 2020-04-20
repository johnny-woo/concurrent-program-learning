package com.woo.threadlearn.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new MainTask());
        SubTask subTask1 = new SubTask("111",cyclicBarrier);
        SubTask subTask2 = new SubTask("222",cyclicBarrier);
        SubTask subTask3 = new SubTask("333",cyclicBarrier);
        subTask1.start();
        subTask2.start();
        subTask3.start();
        System.out.println("Main thread end");
    }

    static class MainTask extends Thread{
        @Override
        public void run() {
            System.out.println("所有子任务都执行完，开始执行主任务");
        }
    }

    static class SubTask extends Thread{
        private String taskName;
        private CyclicBarrier cyclicBarrier;

        public SubTask(String taskName,CyclicBarrier cyclicBarrier){
            this.taskName = taskName;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(taskName+"计算开始");
                Thread.sleep(2000);
                System.out.println(taskName+"计算结束，等待其他计算结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(taskName+"等待所有计算结束，才开始余下工作");
        }
    }
}
