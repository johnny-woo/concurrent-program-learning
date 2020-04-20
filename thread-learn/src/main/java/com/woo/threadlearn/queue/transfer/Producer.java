package com.woo.threadlearn.queue.transfer;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<String> queue;

    public Producer(TransferQueue<String> queue){
        this.queue = queue;
    }

    private String produce(){
        return "your lucky number:"+new Random().nextInt(100);
    }

    @Override
    public void run() {
        while(true){
            if(queue.hasWaitingConsumer()){
                try {
                    queue.transfer(produce());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
