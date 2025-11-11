package com.example.testing;

import static com.example.testing.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_BLUE+"hello from another thread"+currentThread().getName());
        try{
            Thread.sleep(6000);
        }catch (InterruptedException e){
            System.out.println(ANSI_BLUE+"Another thread work me up");
            return;
        }
        System.out.println(ANSI_BLUE+"3 sec has passed and i am awake");
    }
}
