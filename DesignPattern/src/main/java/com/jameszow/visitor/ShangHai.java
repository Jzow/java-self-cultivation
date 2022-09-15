package com.jameszow.visitor;

/**
 * 上海人群
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class ShangHai extends Person{

    @Override
    public void accept(Action action) {
        action.getShangHaiResult(this);
    }
}
