package com.jameszow.adapter;

/**
 * 类适配
 *
 * @author James Zow
 * @create 2022/9/11
 */
public class ClassAdapter extends CpuUsingService implements NewFunction{

    @Override
    public <U> U queryStackInfo() {
        return (U) CpuUsingService.getInstance();
    }

}
