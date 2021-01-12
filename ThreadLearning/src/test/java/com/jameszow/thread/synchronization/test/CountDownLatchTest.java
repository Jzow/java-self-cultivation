package com.jameszow.thread.synchronization.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * ClassName: CountDownLatchTest
 * Description: TODD
 * Author: James Zow
 * Date: 2021/1/11 0011 20:58
 * Version:
 **/
public class CountDownLatchTest {

    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done  = new CountDownLatch(concurrency);

        for(int i = 0; i < concurrency; i++){
            executor.execute(() ->{
                ready.countDown();
                try {
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                }
            });
        }

        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        done.await();
        System.out.println(System.nanoTime() - startNanos);
        return System.nanoTime() - startNanos;
    }

    public static void main(String [] args){
    }
}
