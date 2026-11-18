package com.example.testing;

import static com.example.testing.ThreadColor.ANSI_RED;

public class MyRUnnable implements Runnable{


    @Override
    public void run() {
        System.out.println(ANSI_RED+"hello from Myrunnable");
    }
}
