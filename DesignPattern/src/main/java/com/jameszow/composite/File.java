package com.jameszow.composite;

/**
 * 文件抽象类
 *
 * @author James Zow
 * @create 2022/9/14
 */
public abstract class File {

    String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void display();
}
