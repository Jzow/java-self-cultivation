package com.jameszow.intermediary;

/**
 * 微信用户抽象类
 *
 * @author James Zow
 * @create 2022/9/13
 */
public abstract class WechatUser {

    protected  Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String name;

    public WechatUser(String name) {
        this.name = name;
    }

    abstract void receive();

    abstract void send();
}
