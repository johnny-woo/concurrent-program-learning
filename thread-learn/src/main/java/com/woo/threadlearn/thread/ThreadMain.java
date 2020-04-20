package com.woo.threadlearn.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

public class ThreadMain {

    public static void main(String[] arg){
//        ThreadA threadA = new ThreadA();
//        threadA.start();
//        System.out.println("这是主线程");

//        ThreadB threadB = new ThreadB();
//        for(int i=0;i<5;i++) {
//            new Thread(threadB, "线程名称：("+i+")").start();
//        }
//        // 返回主线程
//        Thread threadMain = Thread.currentThread();
//        System.out.println("这是主线程");
//        System.out.println("返回当前线程的线程组中活动线程的数目：" + Thread.activeCount());
//        System.out.println("主线程名称："+threadMain.getName());
//        System.out.println("主线程id："+threadMain.getId());
//        System.out.println("主线程优先级："+threadMain.getPriority());
//        System.out.println("主线程状态："+threadMain.getState());
//        System.out.println("主线程线程组："+threadMain.getThreadGroup());
//        System.out.println("主线程是否活跃："+threadMain.isAlive());
//        System.out.println("主线程是否为守护线程："+threadMain.isDaemon());
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        ThreadC threadC = new ThreadC();
//        FutureTask<String> futureTask = new FutureTask<>(threadC);
//        new Thread(futureTask).start();
//        System.out.println("这是主线程 start");
//
//        try {
//            System.out.println("得到的返回结果是："+futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println("这是主线程 end");

        Thread threadA = new ThreadA();
        Thread threadB = new Thread(new ThreadB());
        threadA.setDaemon(true);
        threadB.start();
        threadA.start();

        Thread threadMain = Thread.currentThread();
        System.out.println("线程A是不是守护线程："+threadA.isDaemon());
        System.out.println("线程B是不是守护线程："+threadB.isDaemon());
        System.out.println("线程main是不是守护线程："+threadMain.isDaemon());

    }
}
