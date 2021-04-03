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
 * 括号最大的深度
 * 给定一个字符串 判断括号的最大深度（），（（）（）），"" 都是有效括号字符串
 * 而)( ，())是无效括号的字符串
 * 例：
 * 输入 S = "(1)+((2))+(((3)))"
 * 输出 R = 3
 */
public class MaxDepth {

    public static void main(String [] args){
        System.out.println(maxDepth("()"));
    }

    public static int maxDepth(String str) {
        int result = 0;
        int left = 0;
        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) == '('){
                left ++;
            }
            if(str.charAt(i) == ')'){
                left --;
            }
            if(result < left){
                result = left;
            }
        }
        return result;
    }
}
