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
 * ClassName: RunningSum
 * 一堆数组动态和
 */
public class RunningSum {

    public static void main(String [] args){
        int [] a = {1, 5, 9, 13};
        int [] result = sum(a);
        for (int v : result){
            System.out.println(v);
        }
    }

    /**
     * 动态数组累加
     * @param numbers 数组元素
     * @return
     * 示例：
     * 输入：nums = [1,5,9,13]
     * 输出：nums = [1,6,15,28]
     * 解释：动态和计算过程为 [1, 1+5, 1+5+9, 1+5+9+13]
     */
    public static int [] sum(int [] numbers){
        int length = numbers.length;
        for (int i = 1; i < length; i++){
            numbers[i] += numbers[i - 1];
        }
        return numbers;
    }

}
