package com.jameszow.visitor;

/**
 * 抽象执行类
 *
 * @author James Zow
 * @create 2022/9/15
 */
public abstract class Action {

    public abstract void getShangHaiResult(ShangHai shangHai);

    public abstract void getSiChuanResult(SiChuan siChuan);
}
