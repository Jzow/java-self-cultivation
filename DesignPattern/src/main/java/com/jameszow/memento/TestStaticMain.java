package com.jameszow.memento;

/**
 * 主函数测试方法
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class TestStaticMain {

    public static void main(String[] args) {
        // 创建一个发起者
        Originator originator = new Originator();

        originator.setState("state: 0");
        System.out.println("发起者数据原始状态:" + originator.getState());

        Memento memento = originator.Originator();

        // 创建管理者
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(memento);

        originator.setState("state: 1");
        System.out.println("发起者数据修改后的状态:" + originator.getState());

        originator.recoverFromMemento(caretaker.getMemento());
        System.err.println("发起者数据还原后的状态:" + originator.getState());
    }
}
