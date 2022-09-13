package com.jameszow.composite;

/**
 * 主函数测试方法
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class TestStaticMain {

    public static void main(String[] args) {

        Folder local = new Folder("local");

        TextFile json = new TextFile("data.json");
        ImageFile sun = new ImageFile("sun.jpg");
        VideoFile iphone14 = new VideoFile("iphone14.mp4");
        Folder documents = new Folder("documents");

        local.addFile(json);
        local.addFile(sun);
        local.addFile(iphone14);
        local.addFile(documents);

        // 向documents文件夹添加文件
        TextFile rtsData = new TextFile("2022RTSData.xls");
        TextFile readFace = new TextFile("readFace.pptx");

        documents.addFile(rtsData);
        documents.addFile(readFace);

        System.out.println("-----local文件夹里的文件-----");
        local.display();

        System.out.println("-----删除前Documents文件夹里的文件-----");
        documents.display();

        documents.removeFile(rtsData);

        System.out.println("-----删除后Documents文件夹里的文件-----");
        documents.display();
    }

}
