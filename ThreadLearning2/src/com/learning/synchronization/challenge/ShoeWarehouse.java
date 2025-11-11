package com.learning.synchronization.challenge;

import com.learning.part2.ThreadColor;

import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse {

    private List<Order> shippingItems;

    public final static String[] PRODUCT_LIST=
            {"Running Shoes","Sandals","Boots","sSlippers","High Tops"};

    public ShoeWarehouse() {
        this.shippingItems = new ArrayList<>();
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
        System.out.println(ThreadColor.ANSI_PURPLE+"Incoming :"+item);
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
