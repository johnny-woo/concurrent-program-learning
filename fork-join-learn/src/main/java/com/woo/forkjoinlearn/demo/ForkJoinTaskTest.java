package com.woo.forkjoinlearn.demo;

import java.util.concurrent.*;

public class ForkJoinTaskTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask countTask1 = new CountTask(1, 5);
        Future<Integer> Future1 = forkJoinPool.submit(countTask1);
        try {
            System.out.println("1-5求和=" + Future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        CountTask countTask2 = new CountTask(1, 100);
        Future<Integer> future2 = forkJoinPool.submit(countTask2);
        try {
            System.out.println("1-1000求和=" + future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread end.");
    }

    static class CountTask extends RecursiveTask<Integer> {
        private static int splitSize = 2;
        private int startNum;
        private int endNum;

        public CountTask(int startNum, int endNum) {
            this.startNum = startNum;
            this.endNum = endNum;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            if (endNum - startNum <= splitSize) {
                for (int i = startNum; i <= endNum; i++) {
                    sum += i;
                }
            } else {
                // 分解成2个子任务
                int middle = (endNum + startNum) / 2;
                CountTask countTask1 = new CountTask(startNum, middle);
                CountTask countTask2 = new CountTask(middle+1, endNum);
                // 执行任务1
                countTask1.fork();
                // 执行任务2
                countTask2.fork();
                // 任务返回值求和
                sum = countTask1.join() + countTask2.join();
            }
            return sum;
        }
    }
}
