package com.jameszow.iterator;

/**
 *
 * @author James Zow
 * @create 2022/9/14
 */
public interface Iterator {

    // 是否还有下一个元素
    boolean haveNext();

    // 获取第一个元素
    Object first();

    // 获取下一个元素
    Object next();
}
