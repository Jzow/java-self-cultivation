package com.jameszow.visitor;

/**
 * 好吃的评价
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class Good extends Action{

    @Override
    public void getShangHaiResult(ShangHai shangHai) {
        System.out.println("上海人说这个食物很好吃");
    }

    @Override
    public void getSiChuanResult(SiChuan siChuan) {
        System.out.println("四川人说这个食物很好吃");
    }
}
