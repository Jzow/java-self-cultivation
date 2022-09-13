package com.jameszow.composite;

/**
 * 文本文件类
 * @author James Zow
 * @create 2022/9/14
 */
public class TextFile extends File{

    public TextFile(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("文本文件，文件名："+super.getName());
    }
}
