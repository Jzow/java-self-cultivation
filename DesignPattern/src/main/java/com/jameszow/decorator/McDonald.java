package com.jameszow.decorator;

/**
 * 麦当劳类
 *
 * @author James Zow
 * @create 2022/9/11
 */
public class McDonald implements Chicken{

    @Override
    public void MakeChicken() {
        System.out.println("麦当劳制作了一份炸鸡");
    }
}
