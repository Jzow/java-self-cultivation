package com.jameszow.streams;

import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;

/**
 * ClassName: CountLongWords
 * Description: 创建一个流操作,读取一个文件，统计长度大于12的单词
 * Author: James Zow
 * Date: 2021/1/12 0012 20:59
 * Version:
 **/
public class CountLongWords {

    public static void main(String [] args) throws IOException {
        var contents = new String(Files.readAllBytes(
                Paths.get("../JavaSelfCultivation/StremLibrary/src/main/resources/words.txt")), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\r\n"));

        long count = 0;

        for (String w : words){
            if(w.length() > 12)
                count++;
        }
        System.out.println(count);

        // 顺序流
        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        // 并行流 多线程异步处理集合
        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
