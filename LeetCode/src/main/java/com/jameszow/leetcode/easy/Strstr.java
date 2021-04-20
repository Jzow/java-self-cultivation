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
package com.jameszow.leetcode.easy;

/**
 * 实现 strStr()
 * 给定两个字符串haystack 和 needle 在haystack字符串中找出 needle 字符出现的第一个位置下标，如果不存在返回-1
 * 下标从0开始
 * 输入：haystack = "hello", needle = "ll"
 * 输出: 2
 */
public class Strstr {

    public static void main(String [] args){
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle){
        for (int i = 0; i + needle.length() <= haystack.length(); ++i){
            if(needle.equals(haystack.substring(i, i + needle.length()))){
                return i;
            }
        }
        return -1;
    }
}
