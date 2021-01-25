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
 * ClassName: NumberSum
 * 两数之和（简单）
 */
public class NumberSum {

    public static void main(String [] args){
        int [] a = {1, 5, 9, 10};
        int b = 11;
        int [] result = sum(a, b);
        for (int v : result){
            System.out.println("下标：" + v);
        }
    }

    /**
     * 暴力枚举法
     * @param numbers 数组
     * @param target 目标值
     * @return 下标
     * 两层for循环分别获取数组的两个下标的值，对两个值的和比较目标值，若成立则返回下标，若不成立继续循环
     */
    public static int [] sum(int [] numbers, int target){
        int length = numbers.length;
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if(numbers[i] + numbers [j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return  new int [] {0};
    }
}
