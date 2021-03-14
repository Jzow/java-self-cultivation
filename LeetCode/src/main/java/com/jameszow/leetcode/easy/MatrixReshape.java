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
 * Reshaping the matrix
 * 重塑矩阵（给定一个二维数组和两个正整数x,y）x和y分别表示想要重构的矩阵行数和列数
 * 重构后的矩阵需要跟原始矩阵所有的元素以 相同的行 来遍历
 */
public class MatrixReshape {

    public static void main(String [] args){
        int [][] nums = {{1, 2}, {3, 4}, {4, 3}};
        int x = 2;
        int y = 3;
        matrixReshape(nums, x, y);
    }

    public static int[][] matrixReshape(int[][]nums, int x, int y){
        // 判断给的的矩阵大小和 重构的矩阵大小是否相等
        if(nums.length * nums[0].length != x * y){
            return nums;
        }
        int [][] ans = new int[x][y];
        for (int i = 0; i < nums.length * nums[0].length; ++i){
            ans[i / y][i % y] = nums[i / nums[0].length][i % nums[0].length];
        }
        return ans;
    }
}
