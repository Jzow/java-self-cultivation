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

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This class creates a stream and performs stream operations
 * 这个类创建一个流 并执行流操作
 */
public class CreatingStreams {

    public static class commonMethod{

        // 静态创建流 比如数组
        static Stream<String> words = Stream.of("apple", "balana", "coco");
        // 创建一个不包含任何元素的流
        static Stream<String> nullItem = Stream.empty();

        // 创建无限流的静态方法  Stream 有两个函数可以创建
        static Stream<String> echos  = Stream.generate(() -> "Echos");
        static Stream<Double> number = Stream.generate(Math :: random); // 随机数无限流

        // 创建序列流
        static Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

        // var 定义不能在方法体外
        public static Stream<BigInteger> getBigInteger(){
            var limit = new BigInteger("10000000");
            return Stream.iterate(BigInteger.ZERO, n -> n.compareTo(limit) < 0, n -> n.add(BigInteger.ONE));
        }

    }

    public static <T> void show(String title, Stream<T> stream){
        // 控制打印输出字符范围在10以内（针对顺序流 超过10后... 表示）
        final int SIZE = 10;
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

    public static void main(String [] args) throws IOException {
        Path path = Paths.get("../JavaSelfCultivation/StremLibrary/src/main/resources/words.txt");
        var contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents);
        show("words", words);
        Stream<String> colors = Stream.of("green", "blue", "yellow", "red");
        show("colors", colors);
        Stream<String> nullItem = Stream.empty();
        show("nullItem", nullItem);

        Stream<String> echos  = Stream.generate(() -> "Echos");
        show("echos", echos);
        Stream<Double> randoms = Stream.generate(Math :: random);
        show("randoms", randoms);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        show("integers", integers);

        // Stream流将迭代器转换成一个未知尺寸的可分割的迭代器
        Iterator<Path> iterator = Paths.get("/words").iterator();
        Stream<Path> pathComponets = StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iterator, Spliterator.ORDERED), false);
        show("pathComponets", pathComponets);
    }
}
