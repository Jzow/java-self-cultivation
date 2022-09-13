package com.jameszow.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚合
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class ObjectAggregate implements Aggregate{

    private List<Object> objectList = new ArrayList<>(5);

    @Override
    public void addObject(Object object) {
        objectList.add(object);
    }

    @Override
    public void removeObject(Object object) {
        objectList.remove(object);
    }

    @Override
    public Iterator getIterator() {
        return new ObjectIterator(objectList);
    }
}
