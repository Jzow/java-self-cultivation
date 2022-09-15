package com.jameszow.visitor;

/**
 * 主函数测试方法
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class TestStaticMain {

    public static void main(String[] args) {
        // 创建数据结构
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.add(new ShangHai());
        objectStructure.add(new SiChuan());

        // 好吃
        Good good = new Good();
        objectStructure.display(good);

        // 不好吃
        Bad bad = new Bad();
        objectStructure.display(bad);
    }
}
