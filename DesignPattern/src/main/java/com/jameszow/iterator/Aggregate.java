package com.jameszow.iterator;

/**
 * 抽象聚合
 *
 * @author James Zow
 * @create 2022/9/14
 */
public interface Aggregate {

    void addObject(Object object);

    void removeObject(Object object);

    Iterator getIterator();
}
