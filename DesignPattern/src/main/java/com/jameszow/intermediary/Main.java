package com.jameszow.intermediary;

/**
 * 测试方法
 *
 * @author James Zow
 * @create 2022/9/13
 */
public class Main {

    public static void main(String[] args) {
        // 群聊
        WechatGroup wechatGroup = new WechatGroup();

        User james = new User("james");
        User cindy = new User("cindy");
        User tony = new User("tony");

        wechatGroup.register(james);
        wechatGroup.register(cindy);
        wechatGroup.register(tony);

        // 持有中介者 聊天组
        james.setMediator(wechatGroup);
        cindy.setMediator(wechatGroup);
        tony.setMediator(wechatGroup);

        james.send();
    }
}
