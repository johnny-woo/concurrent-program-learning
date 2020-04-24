package com.woo.monitorlearn.demo;

import java.util.concurrent.*;

public class MonitorThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executorService = new MonitorThreadPoolExecutor(5, 5, 0l
                , TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Main thread end.");
    }

    static class MonitorThreadPoolExecutor extends ThreadPoolExecutor {

        public MonitorThreadPoolExecutor(int arg0, int arg1, long arg2, TimeUnit arg3, BlockingQueue<Runnable> arg4) {
            super(arg0, arg1, arg2, arg3, arg4);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            System.out.println("Thread pool executor beforeExecute." + t.getName());
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            System.out.println("Thread pool executor afterExecute." + r);
        }

        @Override
        protected void terminated() {
            System.out.println("terminated getPoolSize:" + this.getPoolSize()
                    + ",getCorePoolSize:" + this.getCorePoolSize()
                    + ",getLargestPoolSize:" + this.getLargestPoolSize()
                    + ",getActiveCount:" + this.getActiveCount()
                    + ",getTaskCount:" + this.getTaskCount()
                    + ",getCompletedTaskCount:" + this.getCompletedTaskCount());
            System.out.println("Thread pool executor terminated.");
        }
    }
}
