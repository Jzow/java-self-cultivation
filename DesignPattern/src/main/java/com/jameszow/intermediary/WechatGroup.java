package com.jameszow.intermediary;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信聊天组
 *
 * @author James Zow
 * @create 2022/9/13
 */
public class WechatGroup extends Mediator{

    private List<WechatUser> users = new ArrayList<>(5);

    @Override
    public void register(WechatUser wechatUser) {
        if(wechatUser != null) {
            users.add(wechatUser);
        }
    }

    @Override
    public void send(WechatUser wechatUser) {
        for (WechatUser user : users) {
            if(!user.equals(wechatUser)) {
                user.receive();
            }
        }
    }
}
