/*
 * Copyright 2021 Apache All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.jameszow.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class uses the filter() map() flatmap() method to manipulate the Stream transformation
 * 这个类是使用filter map flatmap 方法操作流转换
 */
public class StreamConvert {

    private static final List<String> words = new ArrayList<>(){
        // 两个大括号 第一对大括号表明new()
        {
            add("filter");
            add("map");
            add("resources");
            add("stream");
        }
    };

    public static void main(String [] args){
        //streamFilter();
        streamMap();
        // streamFlatmap();
    }

    public static void streamFilter(){
        // 截取大于5字符的字母
        Stream<String> longWords = words.stream().filter(w -> w.length() > 5);
        show("longWords", longWords);
    }

    public static void streamMap(){
        // 转换大写
        Stream<String> uppercaseWords = words.stream().map(String::toUpperCase);
        show("uppercaseWords", uppercaseWords);
        // 截取字符串首字母
        Stream<String> subWords = words.stream().map(s -> s.substring(0, 1));
        show("subWords", subWords);
    }

    public static void streamFlatmap(){
        // 结果 [...["f", "i", "l", "t", "e", "r"], ["m", "a", "p"],...]
        Stream<Stream<String>> mapResult = words.stream().map(s -> codePoints(s));
        show("mapResult", mapResult);
        // flatMap 可将当前所有的字符流连在一块 结果[..."f", "i", "l", "t", "e", "r", "m", "a", "p",...]
        Stream<String> flatmapResult = words.stream().flatMap(s -> codePoints(s));
        show("flatmapResult", flatmapResult);
    }

    /**
     * 处理需要用两个char的值来表示Unicode字符
     * @param s 字符串
     * @return 返回一个处理完unicode字符的流
     */
    public static Stream<String> codePoints(String s){
        var rsult = new ArrayList<String>();
        int i = 0;
        while (i < s.length()){
            int j = s.offsetByCodePoints(i,1);
            rsult.add(s.substring(i, j));
            i = j;
        }
        return rsult.stream();
    }

    public static <T> void show(String title, Stream<T> stream){
        final int SIZE = 50;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.println(title + ": ");

        for (int i = 0; i < firstElements.size(); i++){
            if(i > 0)
                System.out.println(", ");
            if(i < SIZE)
                System.out.println(firstElements.get(i));
            else
                System.out.println("...");
        }
        System.out.println();
    }

    /**
     * This class is used to extract sub flow and combine flow test
     * 这个类是用来抽取子流和组合流测试
     */
    public static class ExtractionStream{

        private static String [] contents = {"abcd", "efgh", "ijklm"};

        public static void main(String [] args){
            Stream<Double> randoms = Stream.generate(Math::random).limit(1000);
            show("randoms", randoms);
            // 移除当前流n个的所有元素
            Stream<String> skipStream = Stream.of(contents).skip(1);
            show("skipStream", skipStream);
            // 获取当前流中所有满足条件apple的元素
            Stream<String> takewhileStream = codePoints("apple").takeWhile(s -> "apple".contains(s));
            Stream<String> takewhileStream2 = codePoints("apple").takeWhile(s -> "app".contains(s));
            show("takewhileStream", takewhileStream);
            show("takewhileStream2", takewhileStream2);
            // 获取当前流中所有不满足条件的元素之外的所有元素 也就是banana为6个字符 条件大于7个字符的就是不满足条件 dropwhileStream就会存在
            Stream<String> dropwhileStream = codePoints("banana").dropWhile(s -> s.trim().length() > 7);
            Stream<String> dropwhileStream2 = codePoints("banana").dropWhile(s -> s.trim().length() < 7);
            show("dropwhileStream", dropwhileStream);
            show("dropwhileStream2", dropwhileStream2);
            // 返回两个流连接起来的元素，第一个流不能是无限的，若是无限的第二个流用于不会执行合并
            Stream<String> concatStream = Stream.concat(codePoints("apple"), codePoints("banana"));
            show("concatStream", concatStream);
        }
    }

    /**
     * This class is a transformation that operates on other flows and can be understood as an extension
     * 这个类是操作其他流的转换，可以理解为扩展
     */
    public static class OtherStreamConvert{

        public static void main(String [] args){
            // 剔除所有重复的元素
            Stream<String> distinctStream = Stream.of("apple","apple","banana").distinct();
            show("distinctStream", distinctStream);
            // 流的排序，可以按照字符串长的进行排序
            Stream<String> sortStream = Stream.of("watermelon","apple","banana").sorted(
                    Comparator.comparing(String::length).reversed());
            show("sortStream", sortStream);
            // peek 会产生新的流 并且调用一个函数，举个例子每当获取一个流打印一次eat
            Stream<String> peekStream = Stream.of("apple","banana").peek(s -> System.out.println("eat>>"));
            show("peekStream", peekStream);
        }
    }

}
