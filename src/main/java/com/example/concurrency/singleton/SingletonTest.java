package com.example.concurrency.singleton;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//使用枚举实现单例模式最安全
public class SingletonTest {

    private SingletonTest(){}

    private static SingletonTest singletonTest;

    public static SingletonTest getInstance(){

        return Singleton.INSTANCE.getInstance();
    }

    private  enum  Singleton{
        INSTANCE;

        private SingletonTest singletonTest;

        //JVM保证这个方法只被调用一次
        Singleton(){
            singletonTest = new SingletonTest();
        }

        public SingletonTest getInstance(){
            return singletonTest;
        }
    }

}

class Woshinibaba{

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            SingletonTest singletonTest = SingletonTest.getInstance();
            System.out.println(singletonTest.hashCode());
        });

        executorService.execute(()->{
            SingletonTest singletonTest1 = SingletonTest.getInstance();
            System.out.println(singletonTest1.hashCode());
        });
        executorService.shutdown();

//         Thread thread = new Thread(){
//             @Override
//             public void run() {
//                 System.out.println(1);
//             }
//         };
//         thread.start();
//
//
//
//        Thread thread1 = new Thread(){
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        };
//        thread1.start();

    }

}