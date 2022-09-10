package com.jameszow.adapter;

/**
 * 新功能接口
 *
 * @author James Zow
 * @create 2022/9/11
 */
public interface NewFunction {

    /**
     * 查询栈的信息
     * @return
     * @param <U>
     */
    <U> U queryStackInfo();
}
