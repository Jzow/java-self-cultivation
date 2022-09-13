package com.jameszow.command;

/**
 *
 * 调用者 请求发送类
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
