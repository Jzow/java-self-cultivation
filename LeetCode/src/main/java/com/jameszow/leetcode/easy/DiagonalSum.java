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
 * 矩阵对角线元素求和
 * 给定一个矩阵 二维数组nums = {{1,2,3} ,
 *                            {4,5,6} ,
 *                            {7,8,9}}
 * 1 + 5 +9 + 3 + 7 = 25
 * 5只会被计算一次
 */
public class DiagonalSum {

    public static void main(String [] args){
        int [][] n = {{1,2,3} , {4,5,6} , {7,8,9}};
        System.out.println(diagonalSum(n));
    }

    /**
     * 循环遍历数组法
     * @param nums
     * @return
     */
    public static int diagonalSum(int [][] nums){
        int result = 0;
        for (int i = 0; i < nums.length; ++i){
            for (int j = 0; j < nums.length; ++j){
                if(i == j || i + j == nums.length - 1){
                    result += nums[i][j];
                }
            }
        }
        return result;
    }
}
