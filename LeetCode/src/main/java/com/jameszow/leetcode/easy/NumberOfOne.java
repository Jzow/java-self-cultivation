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
 * 位1的个数
 *
 * 输入一个无符号整数，返回其二进制表达式中数字位"1"的个数（汉明重量）
 */
public class NumberOfOne {

    public static void main(String [] args){
        System.out.println(hammingWeight(0000000000000000000000000001011));
    }

    public static int hammingWeight(int n){
        int result = 0;
        while (n != 0){
            result += n & 1;
            /*
             * >> 算术右移 舍弃最低位，高位用符号填补;
             * >>> 逻辑右移 舍弃最低为，高位用0填补
             * 对于负数而言 二进制最高位是1，如果用算数右移那么高位补填的是1，也就是n永不会为0，就会超时
             * Java中需要用逻辑右移 while的条件才能是n!=0
             */
            n >>>= 1;
        }
        return result;
    }

}
