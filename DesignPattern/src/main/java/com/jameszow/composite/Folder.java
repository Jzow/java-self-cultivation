package com.jameszow.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class Folder extends File{

    private List<File> fileList;

    public Folder(String name) {
        super(name);
        fileList = new ArrayList<>();
    }

    @Override
    void display() {
        for (File file : fileList) {
            file.display();
        }
    }

    void addFile(File file) {
        fileList.add(file);
    }

    void removeFile(File file) {
        fileList.remove(file);
    }
}
