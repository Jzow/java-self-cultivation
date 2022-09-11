package com.jameszow.decorator;

/**
 * 肯德基类
 *
 * @author James Zow
 * @create 2022/9/11
 */
public class KFC implements Chicken{

    @Override
    public void MakeChicken() {
        System.out.println("肯德基制作了一份炸鸡");
    }
}
