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
 * 检查两个字符串数组是否相等，如果两个数组表示的字符串相同返回true，否则返回false
 * 数组表示的字符串是由数组中的所有元素 按顺序连接形成的字符
 * 给出两个字符串数组s1 = ["ab","d"] , s2 = ["a", "bd"]
 *
 */
public class ArrayStringsAreEqual {

    public static void main(String [] args){
        String [] a = {"ab", "d"};
        String [] b = {"a", "bd"};
        System.out.println(arrayStringsAreEqual(a,b));
    }

    public static boolean arrayStringsAreEqual(String [] s1, String [] s2){
        if(s1.length == 0 && s2.length == 0){
            return false;
        }
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        for(int i = 0; i < s1.length; ++i){
            a.append(s1[i]);
        }
        for (int j = 0; j < s2.length; ++j){
            b.append(s2[j]);
        }
        if(String.valueOf(a).equals(String.valueOf(b))){
            return true;
        }
        return false;
    }
}
