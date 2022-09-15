package com.jameszow.visitor;

/**
 * 不好吃的评价
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class Bad extends Action{

    @Override
    public void getShangHaiResult(ShangHai shangHai) {
        System.err.println("上海人说这个食物不好吃");
    }

    @Override
    public void getSiChuanResult(SiChuan siChuan) {
        System.err.println("四川人说这个食物不好吃");
    }
}
