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
 * 统计有多少小于当前数字的数字
 * 给定一个数组 A = {8, 6, 5, 3, 1}
 * 统计该数组里比当前下标小于的数字的数量 返回数组形式
 * 输入A = {8 ,6 ,5, 3, 1}
 * 输出B = {4 ,3, 2, 1, 0}
 */
public class SmallerNumbersThanCurrent {

    public static void main(String [] args){
        int [] n = {8 ,6 ,5, 3, 1};
        for(int i :  smallerNumbersThanCurrent(n)){
            System.out.println(i);
        }
    }


    public static int [] smallerNumbersThanCurrent(int [] nums){
        int [] result = new int[nums.length];
        for(int i = 0 ; i < nums.length; ++i){
            for(int j = 0; j < nums.length; ++j){
                if(i == j) continue;
                if(nums[i] > nums[j]){
                    result [i]++;
                }
            }
        }
        return result;
    }
}
