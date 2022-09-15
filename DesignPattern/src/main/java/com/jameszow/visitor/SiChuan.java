package com.jameszow.visitor;

/**
 * 四川人群
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class SiChuan extends Person{

    @Override
    public void accept(Action action) {
        action.getSiChuanResult(this);
    }
}
