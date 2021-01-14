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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class is used to test the implementation of read-write split lock
 * 此类用于测试读写分离锁的实现
 * Description: 读写分离 读写锁（读-读能共存，读-写不能共存，写-写不能共存）
 */
public class Cache {
    private static volatile Map<String, Object> map= new HashMap<String, Object>();

    private static ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();

    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock =reentrantReadWriteLock.writeLock();
    /**
     * 写
     * @param key
     * @param object
     */
    public static void put(String key, Object object){
        try{
            writeLock.lock();
            System.out.println("正在写入key:"+key+",value:"+object+"开始。。");
            Thread.sleep(100);
            Object obj=map.put(key,object);
            System.out.println("写入key:"+key+",value:"+object+"结束。。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 读
     * @param key
     * @return
     */
    public static Object get(String key){
        try{
            readLock.lock();
            System.out.println("正在读取key:"+key+"开始。。");
            Thread.sleep(100);
            Object obj=map.get(key);
            System.out.println("读取key:"+key+",value:"+obj+"结束。。");
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Cache.put(i+"",i+"");
                }
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Cache.get(i+""));
                }
            }
        }).start();
    }
}

