package com.learning.executorService;

import com.learning.part2.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShoeWarehouse {


    private List<Order> shippingItems;

    public final static String[] PRODUCT_LIST=
            {"Running Shoes","Sandals","Boots","sSlippers","High Tops"};

    private  final ExecutorService fulfillmentService;
    public ShoeWarehouse() {
        this.shippingItems = new ArrayList<>();
        fulfillmentService = Executors.newFixedThreadPool(3);
    }

    public void shutDown(){
        fulfillmentService.shutdown();
    }
    public synchronized void  receiveOrder(Order item)
    {
        while (shippingItems.size()>20){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        shippingItems.add(item);
        System.out.println(ThreadColor.ANSI_PURPLE+Thread.currentThread().getName()+"Incoming :"+item);
        fulfillmentService.submit(this::fullfillOrder);
        notifyAll();
    }
    public synchronized Order fullfillOrder(){
        while (shippingItems.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        Order item =shippingItems.remove(0);
        System.out.println(ThreadColor.ANSI_GREEN +Thread.currentThread().getName()+":"+"Fulfilled:"+item);
        notifyAll();
        return item;
    }
}
