package com.jameszow.singleton;

/**
 * 单例模式 - 饿汉式
 * @author James Zow
 * @create 2022/9/7
 */
public class SingletonTwo {

    private static SingletonTwo instance = new SingletonTwo();

    private SingletonTwo() {

    }

    public static SingletonTwo getInstance() {
        return instance;
    }
}
