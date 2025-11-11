package com.learning.executorService;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

record Order(long orderId, String item, int qty){
};
public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {

        ShoeWarehouse shoeWarehouse = new ShoeWarehouse();
        ExecutorService orderService = Executors.newCachedThreadPool();

        Callable<Order> orderingTask = () -> {
            Order newOrder;
            try {
                newOrder = generateOrder();
                Thread.sleep(random.nextInt(500, 5000));
                shoeWarehouse.receiveOrder(newOrder);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return newOrder;
        };

        List<Callable<Order>> task = Collections.nCopies(15,orderingTask);
        try {
            orderService.invokeAll(task);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        orderService.shutdown();
        try {
            orderService.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shoeWarehouse.shutDown();
    }

    private static Order generateOrder(){
        return new Order(random.nextLong(100000,9999999),
                ShoeWarehouse.PRODUCT_LIST[random.nextInt(0,5)],
                random.nextInt(1,4));
    }
}
