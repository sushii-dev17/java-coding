package com.example.testing;

import static com.example.testing.ThreadColor.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE+"hello from main thread");

        AnotherThread obj = new AnotherThread();
        obj.setName("==Another Thread=");
        obj.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN+"hello from anonymous class");
            }
        }.start();



        Thread myRunn= new Thread(new MyRUnnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED+"hello from the anonymous class's imple");
                try {
                    obj.join(2000);
                    System.out.println(ANSI_RED+"Another thread terminated, or timed out so I am running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED+"I could not wait after all. I was interupped");
                }
            }
        });
        myRunn.start();
        System.out.println(ANSI_PURPLE+"hello again from main thread.");

    }
}
