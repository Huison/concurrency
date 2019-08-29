package com.example.concurrency.count;

import com.example.concurrency.annocations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@NotThreadSafe
@Slf4j
public class CountExample1 {

    //请求总线程数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    //计数器
    public static int count = 0;

    public static void main(String[] args) throws Exception{
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量 允许并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器闭锁  所有的线程结束后统计计数结果
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        //将所有的请求放入线程池
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //判断当前线程是否运行被执行
                    semaphore.acquire();
                    add();
                    //释放当前线程
                    semaphore.release();
                } catch (Exception e){
                    e.printStackTrace();
                }
                //计数减一
                countDownLatch.countDown();
            });
        }
        //所有线程执行完之后打印count的值
        countDownLatch.await();
        //关闭线程池
        executorService.shutdown();
        log.info("count-> " + count);

    }

    //线程[不安全]方法
    private static void add(){
        count++;
    }
}


