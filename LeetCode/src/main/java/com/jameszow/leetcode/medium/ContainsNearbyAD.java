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

import java.util.TreeSet;

/**
 * 存在重复元素III
 *
 * 给定一个数组和两个整数k和t 判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t 同时又满足 abs(i - j) <= k
 * 如果存在则返回 true，不存在返回 false
 */
public class ContainsNearbyAD {

    public static void main(String [] args){
        int [] n = {1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(n,3,0));
    }

    /**
     * 使用红黑树解题
     * 当「查询」动作和「插入/删除」动作频率相当时，更好的选择是使用「红黑树」
     * @param num
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int [] num, int k, int t){
        int length = num.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < length; ++i){
            Long u = num[i] * 1L;
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = treeSet.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = treeSet.ceiling(u);
            if(l != null && u - l <= t) return true;
            if(r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            treeSet.add(u);
            if(i >= k) treeSet.remove(num[i - k] * 1L);
        }
        return false;
    }
}
