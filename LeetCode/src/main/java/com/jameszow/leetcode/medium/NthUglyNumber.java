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
package com.jameszow.leetcode.medium;

/**
 * 丑数II
 * 给一个正整数n，找出并返回第n个丑数
 * 丑数就只是包含2 3 和/或5 的正整数
 */
public class NthUglyNumber {

    public static void main(String [] args){
        System.out.println(nthUglyNumber(10));
    }

    /**
     * 使用动态规划
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n){
        int [] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for(int i = 2; i <= n; ++i){
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if(dp[i] == num2){
                p2 ++ ;
            }
            if(dp[i] == num3){
                p3 ++;
            }
            if(dp[i] == num5){
                p5 ++;
            }
        }
        return dp[n];
    }
}
