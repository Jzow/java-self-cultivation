package com.jameszow.intermediary;

/**
 * 用户类
 *
 * @author James Zow
 * @create 2022/9/13
 */
public class User extends WechatUser{

    public User(String name) {
        super(name);
    }

    @Override
    void receive() {
        System.out.println(name + "收到了消息");
    }

    @Override
    void send() {
        System.out.println(name + "发送了消息");
        mediator.send(this);
    }
}
