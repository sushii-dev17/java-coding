package com.example.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ABlockQueue {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(()->{

            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("producer produces data: " + i);
                    queue.put(i);
                    Thread.sleep(200);
                }
                queue.put(-1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {

            try {
                while (true) {
                    Integer consumedData = queue.take();
                    if(consumedData ==-1){
                        System.out.println("consumer received small signal");
                        break;
                    }
                    System.out.println("consumed data:" + consumedData);
                    Thread.sleep(600);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
