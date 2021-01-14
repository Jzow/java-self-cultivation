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

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ClassName: StopThread
 * Description: 当多个线程共享可变的数据时候，每个读或者写的线程都必须执行同步，
 * 如若不同步，会导致主线程修改的数据，后面的线程是无法看到主线程修改的数据，
 * 同步线程可使用synchronized关键字对方法进行修饰，或者最好使用volatile关键字进行同步
 * Author: James Zow
 * Date: 2021/1/5 0005 21:47
 * Version: 1.0
 **/
public class StopThread {

    private static boolean stopRequested;

    public static class StopThreadTest{

        private static String printStr(){
            return "test";
        }

        /**
         * 这个方法 它的线程会死循环，因为没有同步。
         * 后面的线程看不到前面的主线程对stopRequested值做true的改变，因此它会一直循环下去
         * @throws InterruptedException
         */
        public static void forRunThread() throws InterruptedException {
            Thread backgroundThread = new Thread(() -> {
                int i = 0;
                while (!stopRequested)
                    i++;
            });
            backgroundThread.start();

            TimeUnit.SECONDS.sleep(1);
            stopRequested = true;
        }
    }

    public static class StopThreadTest2{

        private static synchronized void requestStop(){
            stopRequested = true;
        }

        private static synchronized boolean stopRequested(){
            return stopRequested;
        }

        /**
         * 增加synchronized关键字
         * 读写都需要同步，线程才能起到同步的作用，如果只同步写方法，那么线程还是会死循环
         * @throws InterruptedException
         */
        public static void synchronizedThread() throws InterruptedException {
            Thread synchronizedThread = new Thread(() -> {
                int j = 0;
                while (!stopRequested())
                    j++;
            });
            synchronizedThread.start();

            TimeUnit.SECONDS.sleep(1);
            requestStop();
        }
    }

    public static class volatileThreadTest{

        private static volatile boolean stopRequested;

        /**
         * AtomicLong 是在使用volatile的关键字返回数据i++不同累加的值导致不是原子性所使用的一个class 它继承了Number实现了java.io.Serializable
         * 只要不超过2的32次方 使用volatile 修饰也是ok的，超过了就需要用synchronized同步或者AtomicLong类修饰，保持变量为原子性，保证线程之间同步。
         */

        private static final AtomicLong nextNum = new AtomicLong();

        private static long generateNum(){
            return nextNum.getAndIncrement();
        }

        public static void printNum(){
            System.out.println(generateNum());
        }

        /**
         * volatile 关键字表示该变量是线程共享的
         * @throws InterruptedException
         */
        public static void volatileThread() throws InterruptedException {
            Thread volatileThread = new Thread(() -> {
               int k = 0;
               while (!stopRequested)
                   k++;
            });

            volatileThread.start();

            TimeUnit.SECONDS.sleep(1);
            stopRequested = true;
        }
    }
}
