package com.jameszow.visitor;

/**
 * 抽象人群类
 *
 * @author James Zow
 * @create 2022/9/15
 */
public abstract class Person {

    public abstract void accept(Action action);
}
