package com.example.concurrency.count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {
    static boolean ges = false;
    static  int a;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = get();
            ges = true;
        });
        executorService.execute(() -> {
                while (!ges){
                    System.out.println(2);
                }
            System.out.println("sss" + a);
        });

    }


    static int get(){
        return 1;
    }
}
