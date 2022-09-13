package com.jameszow.composite;

/**
 * 图像文件类
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class ImageFile extends File{

    public ImageFile(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("图片文件，文件名："+super.getName());
    }
}
