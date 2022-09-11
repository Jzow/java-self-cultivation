package com.jameszow.decorator;

/**
 * 炸鸡 装饰器增强功能
 *
 * @author James Zow
 * @create 2022/9/11
 */
public class ChickenDecorator implements Chicken{

    private Chicken chicken;

    /**
     * 构造方法传入炸鸡
     * @param chicken
     */
    public ChickenDecorator(Chicken chicken){
        this.chicken = chicken;
    }

    @Override
    public void MakeChicken() {
        chicken.MakeChicken();

        checkChicken();
    }

    /**
     * 增强的功能
     */
    public void checkChicken() {
        System.err.println("检查炸鸡是否存在卫生问题");
    }
}
