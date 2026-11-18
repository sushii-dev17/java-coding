package com.learning.schedulingTask;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM,
                FormatStyle.LONG);

        Callable<ZonedDateTime> waiThenDOIt = () ->{
            ZonedDateTime ztd;
            try{
                TimeUnit.SECONDS.sleep(2);
                ztd = ZonedDateTime.now();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            return ztd;
        };

        var threadPool = Executors.newFixedThreadPool(2);
        List<Callable<ZonedDateTime>> list = Collections.nCopies(4,waiThenDOIt);

        try {
            System.out.println("--->"+ZonedDateTime.now().format(dtf));
            try {
                List<Future<ZonedDateTime>> futures = threadPool.invokeAll(list);
                for (Future<ZonedDateTime> result:futures){
                    try{
                        System.out.println(result.get(1,TimeUnit.SECONDS).format(dtf));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }finally {
            threadPool.shutdown();
        }

    }
}
