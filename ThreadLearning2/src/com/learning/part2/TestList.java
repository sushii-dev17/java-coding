package com.learning.part2;

public class TestList implements Runnable{

    public static void main(String[] args) {

        Thread t1 = new Thread(new TestList());
        Thread t2 = new Thread(new TestList());
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
       for (int i=0;i<10;i++){
           System.out.println(i);
       }
    }
}
