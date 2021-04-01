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
 * 解压缩编码列表
 * 给一个以行程长度编码压缩的整数列表nums
 * 考虑每队相邻的两个元素[freq, val] = [nums[2*i], nums[2*i+1]] i >= 0
 * 需要从左到右链接所有子列表生成解压后的列表
 *
 * 输入：nums = [3,5,4,2]
 * 第一对[3,5]代表5出现的次数为3生成[5,5,5]
 * 第二对[4,2]代表2出现的次数为4生成[2,2,2,2]
 * 链接 [5,5,5] + [2,2,2,2]
 * 输出[5,5,5,2,2,2,2]
 */
public class DecompressRLElist {

    public static void main(String [] args){
        int [] n = {3,5,4,2};
        for (Integer item : decompressRLElist(n)){
            System.out.println(item);
        }
    }

    public static int [] decompressRLElist(int [] nums){
        int len = 0;
        // i=i+2 取出偶数下标0 2 代表新数组的长度
        for (int i = 0; i < nums.length; i=i+2) {
            // 得到 3 + 4 = 7
            len += nums[i];
        }
        // 赋予新的数组长度7
        int[] result = new int[len];
        // 定义新数组下标起始位置0
        int index = 0;
        // 第一次for循环取出偶数下标
        // 第二次循环基于下标的数量进行累加
        for (int i = 0; i < nums.length; i=i+2) {
            for (int j = 0; j < nums[i]; j++) {
                // 新数组的下标元素从0开始依次向后面的nums下标数奇数进行赋值
                result[index] = nums[i+1];
                index++;
            }
        }
        return result;
    }
}
