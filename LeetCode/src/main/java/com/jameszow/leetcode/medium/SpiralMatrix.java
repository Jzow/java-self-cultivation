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

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵，按照顺时针螺旋顺序，返回矩阵中的所有元素
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 采用模拟法，可以知道初始位置是在左上方，向右开始顺时针访问，当路径超出界限或者经过之前已经访问的位置时，顺时针旋转下一个方向
 * 判断矩阵是否进入之前访问过的元素，需要模拟创建一个与输入矩阵大小相同的辅助矩阵（auxiliary metrix），将元素被访问时，auxiliary metrix中对应的元素都设为已访问
 * 当路径长度达到输入矩阵的所有元素数量 说明已经走完了路线
 */
public class SpiralMatrix {

    public static void main(String [] args){
        int [][] testMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(testMatrix));
    }

    public static List<Integer> spiralOrder(int [][] matrix){
        List<Integer> resultList = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0){
            return resultList;
        }
        int rows = matrix.length;
        int cloumns = matrix[0].length;
        int total = rows * cloumns;
        // 验证是否已访问过
        boolean [][] visited = new boolean[rows][cloumns];
        // 创建模拟矩阵
        int row = 0 , cloumn = 0;
        // 顺时针顺序 右下左上 0, 1 row不变 cloum一直+1，1, 0 row一直+1，cloumn不变 0, -1 顺序对调
        int [][] auxiliaryMetrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int auxiliaryMetrixIndex = 0;
        for (int i = 0; i< total; ++i){
           resultList.add(matrix[row][cloumn]);
           visited[row][cloumn] = true;
           int nextRow = row + auxiliaryMetrix[auxiliaryMetrixIndex][0];
           int nextColumn = cloumn + auxiliaryMetrix[auxiliaryMetrixIndex][1];
           // 判断下一步是否已经访问过或者超出界限或者已经走过，
           if(nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= cloumns || visited[nextRow][nextColumn]){
               // 余4的话是 代表着 矩阵的 从左到右，从右到下，从下到左，从左到上的方向
               auxiliaryMetrixIndex = (auxiliaryMetrixIndex + 1 ) % 4 ;
           }
           row += auxiliaryMetrix[auxiliaryMetrixIndex][0];
           cloumn += auxiliaryMetrix[auxiliaryMetrixIndex][1];
        }
        return resultList;
    }
}
