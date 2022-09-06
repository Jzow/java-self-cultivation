package com.jameszow.singleton;

/**
 * 单例模式 - 懒汉式
 * @author James Zow
 * @create 2022/9/7
 */
public class Singleton {

    /**
     * 私有静态实例，防止被引用，这里赋值null，目的是实现延迟加载
     */
    private static Singleton instance = null;

    /**
     * 私有无参构造方法 防止被实例化
     */
    private Singleton() {

    }

    /**
     * 懒汉式 静态工程方法 创建实例
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
