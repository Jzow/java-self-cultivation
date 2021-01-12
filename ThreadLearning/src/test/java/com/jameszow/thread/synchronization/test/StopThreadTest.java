package com.jameszow.thread.synchronization.test;

import com.jameszow.thread.synchronization.StopThread;

/**
 * ClassName: test
 * Description: TODD
 * Author: James Zow
 * Date: 2021/1/5 0005 21:43
 * Version:
 **/
public class StopThreadTest {

    public static void main(String [] args) throws InterruptedException {
        // StopThread.StopThreadTest.forRunThread();
        // StopThread.StopThreadTest2.synchronizedThread();
        StopThread.volatileThreadTest.volatileThread();
        StopThread.volatileThreadTest.printNum();
    }
}
