package com.woo.threadlearn.queue;

import java.util.concurrent.DelayQueue;

public class DelayQueueTest {

    public static void main(String[] arg){
        DelayQueue<Student> delayQueue = new DelayQueue<>();
        for(int i=0;i<5;i++){
            Student student = new Student("学生"+i,Math.round(Math.random()*10+i));
            delayQueue.put(student);
        }
        System.out.println("delayQueue.peek()"+delayQueue.peek().getName());
    }
}
