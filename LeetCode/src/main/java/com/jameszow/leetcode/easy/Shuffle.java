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
 * 重新排列数组
 * 给定一个数组nums 给一个 数字n ,数组中有2n个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列
 * 数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组
 * 输入 nums = [1, 5, 7, 8, 9, 2] n = 3
 * 输出 [1, 8, 5, 9, 7, 2]
 */
public class Shuffle {

    public static void main(String [] args){

    }

    public static int [] shuffle(int [] nums, int n) throws Exception {
        if(nums.length > 0 && n == 0){
            throw new Exception("入参数据不能为空");
        }
        int [] result = new int[n * 2];
        for (int i = 0; i < n; ++i){
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[i + n];
        }
        return result;
    }
}
