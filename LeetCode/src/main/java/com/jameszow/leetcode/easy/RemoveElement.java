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
 * 移除元素
 * 给定一个数组nums 和 一个val值，要求在不使用额外的数组空间移除数值等于val的元素
 * 使用O(1)的空间原地修改输入的数组
 * 返回数组长度
 */
public class RemoveElement {

    public static void main(String [] args){
        int [] n = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(n, val));
    }

    public static int removeElement(int [] nums, int val){
        int left = 0, right = nums.length;
        while (left < right){
            if(nums[left] == val){
                nums[left] = nums[right - 1];
                right --;
            }else {
                left ++;
            }
        }
        return left;
    }
}
