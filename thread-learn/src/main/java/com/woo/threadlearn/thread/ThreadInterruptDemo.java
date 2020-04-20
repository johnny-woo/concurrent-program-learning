package com.woo.threadlearn.thread;

public class ThreadInterruptDemo implements Runnable {
    @Override
    public void run() {
        boolean stop = false;
        while (!stop){
            System.out.println("My Thread is running....");
            long time = System.currentTimeMillis();
            while(System.currentTimeMillis()-time<1000){

            }
            if(Thread.currentThread().isInterrupted()){
                break;
            }
        }
        System.out.println("My Thread exiting under request....");
    }

    public static void main(String[] arg) throws Exception{
        Thread thread = new Thread(new ThreadInterruptDemo(), "InterruptDemo Thread");
        System.out.println("Starting Thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Interrupting Thread...");
        thread.interrupt();
        System.out.println("线程是否中断："+thread.isInterrupted());
        Thread.sleep(3000);
        System.out.println("Stopping application");
    }
}
