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
 * 给一个m x n的整数网格a，也可以叫矩阵，其中a[i][j]
 * [i] 表示第几位客户
 * [j] 表示拥有的财富数量
 * 求 返回最富有客户的财富数量
 * 输入：a = [[1, 2, 3], [2, 7, 8]]
 * 输出：17
 */
public class MaxMemory {

    public static void main(String [] args){
        int [][] number = {{1,9,10},{2,5,8},{7,10,7}};
        System.out.println(maximumWealth(number));
    }

    public static int maximumWealth(int [][] money){
        int result = 0;
        int sum = 0;
        for (int i = 0; i < money.length; ++i){
            for (int j = 0; j < money[i].length; ++j){
                sum += money[i][j];
            }
            result = Math.max(result, sum);
            sum = 0;
        }
        return result;
    }
}
