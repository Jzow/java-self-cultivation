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
 * 给出一个整数n, 计算帮返回该整数[各位数之积] 与 [各位数之和] 的差值
 * 输入: n = 587
 * 解：5*8*7 = 280, 5+8+7=20
 * 得: 280-20 = 260
 */
public class SubtractProductAndSum {

    public static void main(String [] args){
        System.out.println(subtractProductAndSum(587));
    }

    public static int subtractProductAndSum(int n){
        // 这里定义1 是为了后面乘积用的 如果是0 拿temp 算出来永远是0
        int temp = 1;
        int temp2 = 0;
        while (n != 0){
            temp *= n % 10;
            temp2 += n % 10;
            n/= 10;
        }
        int result = temp - temp2;
        return result;
    }
}
