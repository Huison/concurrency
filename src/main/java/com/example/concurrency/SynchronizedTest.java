package com.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {
    static int i = 0;
  synchronized void noshane(){
        i++;
      System.out.println(i);

   }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            SynchronizedTest synchronizedTest = new SynchronizedTest();
            synchronizedTest.noshane();
        });

        executorService.execute(() -> {
            SynchronizedTest synchronizedTest = new SynchronizedTest();
            synchronizedTest.noshane();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

}
