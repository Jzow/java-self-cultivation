package com.jameszow.iterator;

/**
 * 主函数测试方法
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class TestStaticMain {

    public static void main(String[] args) {
        ObjectAggregate objectAggregate = new ObjectAggregate();

        objectAggregate.addObject("Rust Book");
        objectAggregate.addObject(500);
        objectAggregate.addObject(false);

        Iterator iterator = objectAggregate.getIterator();
        while (iterator.haveNext()) {
            System.out.println(iterator.next());
        }
    }
}
