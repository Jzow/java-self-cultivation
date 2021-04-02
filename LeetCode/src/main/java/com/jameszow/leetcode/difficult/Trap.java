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
package com.jameszow.leetcode.difficult;

/**
 * 直方图的水量
 * leetcode 题目描述
 * 给定一个数组 数组里是黑柱子的体积
 * <a>https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/shuang-zhi-zhen-an-xing-qiu-jie-xiang-xi-d162/
 * </a>
 */
public class Trap {

    public static void main(String [] args){
        int [] n = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(n));
    }

    /**
     * 求水滴体积，先把黑柱子的体积求和，然后利用左右指针算出每一层的（蓝黑柱子）体积然后累加
     * 水滴 = 总体积（每一层之和）- 黑柱子体积
     * @param nums 黑柱子每X轴坐标的体积
     * @return
     */
    public static int trap(int [] nums){
        // 算出sum黑柱子体积
        int sum = 0;
        for (int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        // 定义左右指针
        int result = 0;
        int hight = 1;
        int leftIndex  = 0;
        int rightIndex = nums.length - 1;
        // 左右指针在向中间缩减的时候，这里左指针一定要小于等于右指针
        while (leftIndex <= rightIndex){
            while (leftIndex <= rightIndex && nums[leftIndex] < hight){
                // 左指针向右边移动
                leftIndex ++ ;
            }
            while (leftIndex <= rightIndex && nums[rightIndex] < hight){
                // 右指针向左边移动
                rightIndex -- ;
            }

            result += rightIndex - leftIndex + 1;
            hight ++;
        }
        return result - sum;
    }
}
