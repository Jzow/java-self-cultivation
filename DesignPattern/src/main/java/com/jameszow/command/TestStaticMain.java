package com.jameszow.command;

/**
 *
 * 主函数测试方法
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class TestStaticMain {

    public static void main(String[] args) {
        ConcreteCommand concreteCommand = new ConcreteCommand(new LightBulb());
        Invoker invoker = new Invoker(concreteCommand);
        invoker.action();
    }
}
