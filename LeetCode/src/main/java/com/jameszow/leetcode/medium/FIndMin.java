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

/**
 * 寻找旋转数组中的最小值
 * 给定一个数组nums,预先按照升序排序，多次旋转找出最小值
 */
public class FIndMin {

    public static void main(String [] args){
        int [] n = {3,4,5,1,2};
        System.out.println(findmin(n));
    }

    /**
     * 使用二分查找 减治法
     * 减治法就是通过二分把每次排除掉不符合元素要求的元素，这样会让空间持续缩减
     * @param nums
     * @return
     */
    public static int findmin(int [] nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
