package com.jameszow.composite;

/**
 * 音视频文件类
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class VideoFile extends File{

    public VideoFile(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("音视频文件，文件名："+super.getName());
    }
}
