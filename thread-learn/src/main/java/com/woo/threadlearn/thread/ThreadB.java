package com.woo.threadlearn.thread;

public class ThreadB implements Runnable {
    @Override
    public void run() {
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread currentThread = Thread.currentThread();
//        System.out.println("当前线程名称："+currentThread.getName());
//        System.out.println("返回当前线程："+currentThread.getName()+"的线程组中活跃线程的数量："+Thread.activeCount());
//        System.out.println("当前线程id："+currentThread.getId());
//        System.out.println("当前线程优先级："+currentThread.getPriority());
//        System.out.println("当前线程状态："+currentThread.getState());
//        System.out.println("当前线程所属线程组："+currentThread.getThreadGroup());
//        System.out.println("当前线程是否活跃："+currentThread.isAlive());
//        System.out.println("当前线程是否为守护线程："+currentThread.isDaemon());
        //System.out.println("这是线程B");

        for(int i=0;i<5;i++){
            System.out.println("线程B第"+i+"次执行");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
