/*
 * Copyright 2021 Apache All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.jameszow.thread.synchronization;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.*;

/**
 * ClassName: Test
 * Description: TODD
 * Author: James Zow
 * Date: 2020/11/15 0015 15:08
 * Version:
 **/
public class ExecutorService {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args){
        alibabaThreadPool();
    }
    Date a = Date.from(Instant.MAX);

    public static void executorServiceTest(){
        /**
         * 可缓存线程池
         * 适用场景：适用于耗时少，任务量大的情况
         * 1.线程数无限制（没有核心线程，全部是非核心线程）
         * 2.有空闲线程则复用空闲线程，若无空闲线程则新建线程
         * 3.一定程序减少频繁创建/销毁线程，减少系统开销
         */
        java.util.concurrent.ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * 定长线程池
         * 1.有核心线程，核心线程数就是线程的最大数量（没有非核心线程）
         * 2.可控制线程最大并发数（同时执行的线程数）
         * 3.超出的线程会在队列中等待
         */
        java.util.concurrent.ExecutorService executorService2 = Executors.newFixedThreadPool(500);

        /**
         * 单线程化的线程池
         * 1.有且仅有一个工作线程执行任务
         * 2.所有任务按照指定顺序执行，即遵循队列的入队出队规则
         */
        java.util.concurrent.ExecutorService executorService3 =Executors.newSingleThreadExecutor();

        /**
         * 定长线程池
         * 1.支持定时及周期性任务执行。
         * 2.有核心线程，也有非核心线程
         * 3.非核心线程数量为无限大
         */
        java.util.concurrent.ExecutorService executorService4 =Executors.newScheduledThreadPool(1);

        /**
         * 结合了newSingleThreadExecutor()和newScheduledThreadPool(1);
         */
        java.util.concurrent.ExecutorService executorService5 =Executors.newSingleThreadScheduledExecutor();

        executorService2.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10; i++){
                    System.out.println("6");
                }
            }
        });
    }

    public static void alibabaThreadPool(){
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "~~date：" + Instant.now());
            });
        }
        //终止线程池
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");
    }
}
