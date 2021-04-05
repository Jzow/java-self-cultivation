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

import java.util.Arrays;

/**
 * 合并有序数组
 * 给定两个有序数组nums1 和 nums2 请将nums2合并到nums1 使nums1变为一个有序数组
 * 初始化的nums1和nums2的元素数量分别是m和n 可以假设nums1的空间大小等于m+n
 */
public class MergeArray {

    public static void main(String [] args){
        int [] a = {1,2,3,0,0,0};
        int m = 3;
        int [] b = {2,5,6};
        int n = 3;
        merge(a,m,b,n);
    }

    public static void merge(int [] nums1, int m, int [] nums2, int n){
        for (int i = 0; i != n; ++i){
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        for(int item : nums1){
            System.out.println(item);
        }
    }

}
