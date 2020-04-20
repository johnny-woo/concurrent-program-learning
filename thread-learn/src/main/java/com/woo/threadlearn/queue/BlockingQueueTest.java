package com.woo.threadlearn.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] arg){
        //BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(16);
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(16);
        for(int i=0;i<4;i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        String log = blockingQueue.take();
                        parseLog(log);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for(int i=0;i<16;i++){
            String log = (i+1)+"-->";
            try {
                blockingQueue.put(log);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void parseLog(String log){
        System.out.println(log+System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
