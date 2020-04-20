package com.woo.forkjoinlearn.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) {
        Callable<String> callable = () -> "Sub task 1 completed";
        FutureTask<String> futureTask1 = new FutureTask<>(callable);
        new Thread(futureTask1).start();
        try {
            System.out.println(futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Runnable runnable = () -> System.out.println("Sub task 2 completed");
        FutureTask<Integer> futureTask2 = new FutureTask(runnable, 2);
        new Thread(futureTask2).start();
        try {
            futureTask2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread end.");
    }
}
