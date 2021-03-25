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

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子 给定一个数组A 和一个整数n 其中A[i]代表第i个孩子拥有糖果的数目
 * 将额外的n个糖果分配给孩子后，此孩子拥有最多的糖果数量，允许有多个孩子同时拥有最多糖果数量
 * 返回true和false true代表拥有最多糖果的孩子。
 */
public class KidsWithCandies {

    public static void main(String [] args){
        int [] A = {2, 3, 5, 1, 3};
        int n = 3;
        List<Boolean> result = kidsWithCandies(A, n);
        for(Boolean item : result){
            System.out.println(item);
        }
    }

    /**
     * 假设某个孩子的糖果数量为x 其余孩子最大的糖果数量为y , 额外糖果数量为m
     * 得到 x + m >= y
     * max(x, y)得出所有孩子最大的糖果数量 可以得
     * x + m >= max(x ,y)
     * @param A
     * @param n
     * @return
     */
    public static List<Boolean> kidsWithCandies(int [] A, int n){
        List<Boolean> result = new ArrayList<Boolean>();
        // 最多糖果数量
        int maxCandies = 0;
        for(int i = 0; i < A.length; ++i){
            maxCandies = Math.max(maxCandies, A[i]);
        }
        for(int j = 0; j < A.length; ++j){
            result.add(A[j] + n >= maxCandies);
        }
        return result;
    }
}
