package com.jameszow.decorator;

/**
 *
 * 装饰器测试方法
 *
 * @author James Zow
 * @create 2022/9/11
 */
public class TesatStaticMain {

    public static void main(String[] args) {
        Chicken KFCChicken = new KFC();
        KFCChicken.MakeChicken();

        Chicken McDonaldChicken = new McDonald();
        McDonaldChicken.MakeChicken();

        System.out.println("---------增强后----------");

        Chicken KFCChickenDecorator = new ChickenDecorator(KFCChicken);
        KFCChickenDecorator.MakeChicken();

        Chicken McDonaldChickenDecorator = new ChickenDecorator(McDonaldChicken);
        McDonaldChickenDecorator.MakeChicken();
    }
}
