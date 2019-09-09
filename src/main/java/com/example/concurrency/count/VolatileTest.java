package com.example.concurrency.count;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Controller
public class VolatileTest {

    /**
     *
     *  volatile并不能保证变量的原子性
     *
     *
     */
    volatile int i;


    public static void main(String[] args) {
            //    fuck();
        VolatileTest volatileTest = new VolatileTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {

            executorService.execute(()->{
                volatileTest.add();
            });

        }
        executorService.shutdown();
        System.out.println(volatileTest.i);

    }


    static void change(int a, int b){
        a = 3;
        b = a;
    }

    @RequestMapping("/fuck")
    @ResponseBody
    static String fuck(){
        int a = 1;
        int b = 2;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                change(a, b);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("a="+ a + ",b=" + b);
            }
        }).start();

        return "ssss";
    }

    @RequestMapping("/wow")
    @ResponseBody
    public String egz(){
        return "www";
    }

    public  void add(){
        i++;
    }
}
