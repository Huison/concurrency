package com.example.concurrency.count;

import com.example.concurrency.annocations.NotThreadSafe;
import com.example.concurrency.annocations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Slf4j
public class CountExample2 {

    //请求总线程数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    //计数器
    public static AtomicInteger count = new AtomicInteger(0);

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
        log.info("count-> " + count.get());

    }

    //线程安全方法
    private static void add(){
        count.incrementAndGet();

    }

    /**
     *
     *   public final int incrementAndGet() {
     *         return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
     *     }

     *    var1: 表示调用这个方法的对象 count
     *    var2: 表示当前线程的工作内存中值
     *    var4: 表示要增加的值
     *    var5: 表示主内存的值
     *   public final int getAndAddInt(Object var1, long var2, int var4) {
     *         int var5;
     *         do {
     *             //获取主内存的值
     *             var5 = this.getIntVolatile(var1, var2);
     *         }
     *
     *         循环直到工作内存的值等于主内存的值才会更新主内存的值 var5 = var5 + var4
     *         while(!this.compareAndSwapInt(var1, var2, var5, var5: var5 + var4));
     *
     *         return var5;
     *     }
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
}


