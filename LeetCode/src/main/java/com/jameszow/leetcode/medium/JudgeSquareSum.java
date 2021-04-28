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
 * 平方数之和
 *
 * 给定一个非负数n  判断是否存在两个整数a和b，使得a 2次方 + b 2次方 = n
 * 如果存在返回true 不存在返回false
 */
public class JudgeSquareSum {

    public static void main(String [] args){
        System.out.println(judgeSquareSum(5));
    }

    /**
     * 采用双指针
     * @param n
     * @return
     */
    public static boolean judgeSquareSum(int n){
        long left = 0, right = (long) Math.sqrt(n);
        while (left <= right){
            long sum = left * left + right * right;
            if(sum == n){
                return true;
            }else if (sum > right){
                right--;
            }else {
                left++;
            }
        }
        return false;
    }
}
