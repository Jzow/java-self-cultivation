package com.jameszow.adapter;

/**
 *
 * 对象适配
 *
 * @author James Zow
 * @create 2022/9/11
 */
public class ObjectAdapter implements NewFunction{

    private CpuUsingService cpuUsingService;

    @Override
    public <U> U queryStackInfo() {
        return null;
    }
}
