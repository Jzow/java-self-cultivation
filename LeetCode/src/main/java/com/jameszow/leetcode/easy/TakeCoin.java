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
 * 拿硬币
 * 给定一个数组，数组中存放每堆的硬币，选择任意一堆，拿走其中一枚或者二枚硬币
 * 求拿完所有硬币需要多少次数
 * 输入 [2, 3, 10]
 * 输出 8 , 因为假设每次拿2枚，2需要1次，3需要2次，10需要5次。得1+2+5=8
 */
public class TakeCoin {

    public static void main(String [] args){
        int [] a = {2, 3, 10};
        System.out.println(takeCoin(a));
    }

    public static int takeCoin(int [] coins){
        int result = 0;
        // one代表拿一次，tow代表拿二次
        int one = 1, two = 2;
        for (int i = 0; i < coins.length; ++i){
            // 偶数要拿coins[i]/2次，奇数要拿coins[i]/2+1次
            result += coins[i] / 2;
            result += coins[i] % 2;
        }
        return result;
    }
}
