package com.jameszow.intermediary;

/**
 * 中介抽象类
 *
 * @author James Zow
 * @create 2022/9/13
 */
public abstract class Mediator {

    public abstract void register(WechatUser wechatUser);

    public abstract void send(WechatUser wechatUser);
}
