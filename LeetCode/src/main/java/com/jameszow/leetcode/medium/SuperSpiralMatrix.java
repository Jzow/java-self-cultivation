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

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 螺旋矩阵 第二题，取名超级螺旋丸
 * n 为正整数，通过n生成一个从1到n的2次方的所有元素
 * 求 元素按顺时针顺序螺旋排列的 n x n 的矩阵
 *
 * 输入n = 4  1<=n<=20
 * 得 4x4矩阵
 * 还是采用模拟法
 */
public class SuperSpiralMatrix {

    final static int number = 4;

    public static void main(String [] args){
        int [][] result = superSpiralMatrix(4);
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                System.out.println(result[i][j]);
            }
        }
    }

    public static int[][] superSpiralMatrix(int n){
        int maxNumber = n * n;
        // 从1开始计算
        int count = 1;
        int [][] result = new int[n][n];
        int rows = 0 , cloumns = 0;
        // 顺序是从左到右,从上到下一直到矩阵结束，这个是模拟矩阵
        int [][] auxiliaryMetrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int auxiliaryMetrixIndex = 0;
        // 判断从1开始计算矩阵的最大数量 若n=4 那么得到maxNmuber=16, 小于等于16
        while (count <= maxNumber){
            result[rows][cloumns] = count;
            count++;
            int nextRow = rows + auxiliaryMetrix[auxiliaryMetrixIndex][0];
            int nextColumn = cloumns + auxiliaryMetrix[auxiliaryMetrixIndex][1];
            // 判断是否已经走过 和 是否越界
            if(nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || result[nextRow][nextColumn] != 0){
                auxiliaryMetrixIndex = (auxiliaryMetrixIndex + 1) % 4;
            }
            rows = rows + auxiliaryMetrix[auxiliaryMetrixIndex][0];
            cloumns = cloumns + auxiliaryMetrix[auxiliaryMetrixIndex][1];
        }
        return result;
    }

}
