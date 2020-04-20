package com.woo.threadlearn.sync;

public class ThreadCountMain extends Thread {

    private Count2 count;

    public ThreadCountMain(Count2 count){
        this.count = count;
    }

    public void run(){
        count.methodB();
    }

    public static void main(String[] arg){
        Count2 count = new Count2();
        for(int i=0;i<5;i++) {
            ThreadCountMain m = new ThreadCountMain(count);
            m.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5个人干完活，最后的值是："+count.num);
    }
}
