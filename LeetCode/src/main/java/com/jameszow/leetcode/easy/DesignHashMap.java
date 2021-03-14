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
package com.jameszow.leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *              设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）
 * DesignHashMap() 空映射初始化对象
 * void put 向HashMap 插入一个键值对，如果key已经存在映射中，则更新对应的值
 * void remove 如果映射中存在key，则移除key和他对应的value
 * int get 返回特定的key所映射的value 如果映射中不包含key的映射 则返回 -1
 *
 * 解题方法：链地址法
 */
public class DesignHashMap {

    // 构造一个get set的类
    private class Pair{

        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    private static final int BASE = 769;
    private LinkedList [] data;

    public static void main(String [] args){
        DesignHashMap designHashMap = new DesignHashMap();
    }

    public DesignHashMap(){
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i){
            data[i] = new LinkedList<Pair>();
        }
    }

    public static int hash(int key){
        return key % BASE;
    }

    public void put (int key, int value){
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                pair.setValue(value);
                System.out.println("插入值成功");
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }

    public void remove (int key){
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.key == key){
                data[h].remove(pair);
                System.out.println("移除值成功");
                return;
            }
        }
    }

    public int get (int key){
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if (pair.getKey() == key){
                return pair.value;
            }
        }
        return -1;
    }

}
