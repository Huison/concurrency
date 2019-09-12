package com.example.designPatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Vxe {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            executorService.execute(()->{
                String string = new String();
            });
        }

    }
}
