package com.woo.threadlearn.queue;

public class TestDo {

    public static String doSome(String input){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input+":"+System.currentTimeMillis()/1000;
        return output;
    }
}
