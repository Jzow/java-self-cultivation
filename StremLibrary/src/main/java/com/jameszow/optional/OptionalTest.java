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
package com.jameszow.optional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * ClassName: OptionalTest
 * Description: This class How to use Optional API
 */
public class OptionalTest {

    public static void main(String [] args) throws IOException {
        var contents = new String(Files.readAllBytes(
                Paths.get("../JavaSelfCultivation/StremLibrary/src/main/resources/words.txt")), StandardCharsets.UTF_8
        );

        List<String> wordList = List.of(contents);

        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("fred"))
                .findFirst();
        System.out.println(optionalValue.orElse("没有这个单词") + "包含fred");

        Optional<String> optionString = Optional.empty();
        String result = optionString.orElse("N/A");
        System.out.println("result:" + result);
        result = optionString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result:" + result);
        try {
            result = optionString.orElseThrow(IllegalStateException::new);
            System.out.println("result:" + result);
        }catch (Throwable e){
            e.printStackTrace();
        }

        optionalValue = wordList.stream().filter(s -> s.contains("spring")).findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + "包含单词spring"));

        var results = new HashSet<String>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println("added" + added);

        // 测试Optional数字运算 flatMap和stream flatMap一样处理 将多个Optional拼接在一块
        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-2.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));

        Optional<Double> result2 = Optional.of(-4.0)
                .flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println("result2: " + result2);
    }

    public static Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty() : Optional.of(1 + x);
    }

    public static Optional<Double> squareRoot(Double x){
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
