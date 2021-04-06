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

import java.util.Arrays;

/**
 * 给定一个有序数组，请在此数组的基础上删除重复的元素，使每个元素最多出现2次，返回删除后的数组长度
 * 不能使用额外的数组空间
 * 输入 n = {1,1,1,2,2,3}
 * 输出 n = {1,1,2,2,3} 输出5
 */
public class RemoveDuplicates {

    public static void main(String [] args){
        int [] n = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(n));
    }

    /**
     * 双指针
     * nums[slow] 慢指针 表示处理出的数组长度
     * nums[fast] 快指针 表示已经检查过的数组长度
     * 当nums[slow - 2] = nums[fast] 当前检查元素nums[fast]不应该保留
     * @param nums
     * @return
     */
    public static int removeDuplicates(int [] nums){
        int length = nums.length;
        if(length < 2){
            return length;
        }
        int slow = 2 , fast = 2;
        while (fast < length){
            if(nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
