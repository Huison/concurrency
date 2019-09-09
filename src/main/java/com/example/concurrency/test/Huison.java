package com.example.concurrency.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Huison {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Random random = new Random();
//        CountDownLatch countDownLatch = new CountDownLatch(1);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleAtFixedRate(()->{
            if (arrayList!=null){
                arrayList.clear();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList.add(random.nextInt(10));

           // countDownLatch.countDown();
        },1,300, TimeUnit.MILLISECONDS);

//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        executorService.scheduleAtFixedRate(()->{
            try {
                System.out.println(arrayList.get(0));
            } catch (Exception e) {
            }
        },1,1000,TimeUnit.MILLISECONDS);
    }
}
