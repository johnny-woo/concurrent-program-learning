package com.woo.threadpool.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

    public static void main(String[] args) {
        // 创建定长线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int n = i;
            Runnable runnable = () -> {
                System.out.println("runnable " + n + " start");
                try {
                    // 模拟干活
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable " + n + " end");
            };
            // 执行线程
            executorService.execute(runnable);
        }
        // 关闭线程池
        executorService.shutdown();
        System.out.println("Main thread end.");
    }
}
