package com.jameszow.facade;

/**
 * 主函数测试方法
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class TestStaticMain {

    public static void main(String[] args) {
        SystemFacade facade = new SystemFacade();

        facade.doSomething();
    }
}
