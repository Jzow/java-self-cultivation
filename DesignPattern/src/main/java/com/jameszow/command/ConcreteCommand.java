package com.jameszow.command;

/**
 * 具体命令类
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class ConcreteCommand extends Command{

    private LightBulb lightBulb;

    public ConcreteCommand(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    @Override
    public void execute() {
        lightBulb.on();
    }
}
