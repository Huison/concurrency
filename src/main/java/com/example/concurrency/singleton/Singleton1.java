package com.example.concurrency.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton1 {
    private Singleton1(){}

    private static Singleton1 singleton1 = new Singleton1();

    public  static Singleton1 getInstance(){
        return singleton1;
    }


}

class Tte{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            System.out.println(Singleton1.getInstance().hashCode());
        });


        executorService.execute(() -> {
            System.out.println(Singleton1.getInstance().hashCode());
        });

        executorService.shutdown();
    }
}
