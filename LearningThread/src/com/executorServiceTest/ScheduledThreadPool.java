package com.executorServiceTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeFixedThreadPool {

    public static void main(String[] args) throws InterruptedException {

        int availProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i=0;i<50;i++) {
            int taskId=i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName()+"executing task id: "+taskId);
            });
        }
        executorService.shutdown();
    }
}
