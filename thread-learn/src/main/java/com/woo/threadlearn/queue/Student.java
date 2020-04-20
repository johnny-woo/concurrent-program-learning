package com.woo.threadlearn.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Student implements Delayed {
    private String name;
    private long submitTime;
    private long workTime;

    public String getName(){
        return this.name+"交卷，用时"+workTime;
    }

    public Student(String name,long submitTime){
        this.name = name;
        this.workTime = submitTime;
        this.submitTime = TimeUnit.NANOSECONDS.convert(submitTime,TimeUnit.MILLISECONDS)+System.nanoTime();
        System.out.println(this.name+"交卷，用时"+workTime);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(submitTime-System.nanoTime(),unit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Student that = (Student) o;
        return submitTime>that.submitTime?1:(submitTime<that.submitTime?-1:0);
    }
}
