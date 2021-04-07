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
 * 搜索旋转排序数组II
 * 给定一个数组nums，数组中的值不必互不相同
 * 在给定数组之前 nums在未知的某个下标k进行旋转 k = (0 <= k < nums.length)上进行旋转
 * 给定一个旋转后的数组nums和整数target，如果这个数存在nums中返回true 不存在就返回false
 */
public class OrderBinarySearch {

    public static void main(String [] args){
        int [] a = {2,5,6,0,0,1,2};
        int t = 5;
        System.out.println(search(a, t));
    }

    /**
     * 进行二分查找法
     * 但是这当中有一个旋转点的概念
     * @param nums
     * @param target
     * @return
     */
    public static boolean search(int [] nums, int target){
        int left = 0, rigth = nums.length - 1, middle = (left + rigth)/2;
        while (left <= rigth){
            if(nums[left] == target || nums[rigth] == target || nums[middle] == target){
                return true;
            }else if(nums[middle] > target && nums[left] < target){  // 左侧有序区间
                rigth = middle - 1;
            }else if(nums[middle] < target && nums[rigth] > target){  // 右侧有序区间
                left = middle + 1;
            }else { // 还在中间左边+1 右边-1
                left++;
                rigth--;
            }
            middle = (left + rigth)/2;
        }
        return false;
    }
}
