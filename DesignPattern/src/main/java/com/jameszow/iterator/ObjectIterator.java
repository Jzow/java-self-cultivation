package com.jameszow.iterator;

import java.util.List;

/**
 * 对象迭代器
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class ObjectIterator implements Iterator{

    private List<Object> objectList;

    // 遍历时的位置
    private int pos = 0;

    public ObjectIterator(List<Object> objectList) {
        this.objectList = objectList;
    }

    @Override
    public boolean haveNext() {
        return pos < objectList.size();
    }

    @Override
    public Object first() {
        return objectList.get(0);
    }

    @Override
    public Object next() {
        return objectList.get(pos++);
    }
}
