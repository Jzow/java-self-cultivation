package com.jameszow.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据结构
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class ObjectStructure {

    private List<Person> peoples = new ArrayList<>(3);

    public void add(Person person) {
        peoples.add(person);
    }

    public void remove(Person person) {
        peoples.remove(person);
    }

    // 显示美食评价
    public void display(Action action) {
        for (Person people : peoples) {
            people.accept(action);
        }
    }
}
