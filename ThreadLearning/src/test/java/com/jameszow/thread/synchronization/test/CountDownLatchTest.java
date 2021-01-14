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
