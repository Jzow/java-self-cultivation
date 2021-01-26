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
 * ClassName: Dominoes
 * 多米诺骨牌算法
 */
public class Dominoes {


    public static void main(String [] args){
        int[][] a = new int[][] {{1, 3}, {5, 7}, {3, 1}, {7, 9}};
        System.out.println(numEquivDominoPairs(a));
    }


    /**
     * @param dominoes 多米诺骨牌数组
     * @return 返回等价骨牌对应数量
     * 例：int [] a = [[1, 3], [5, 7], [3, 1], [7, 9]]
     * 规则：假设牌可以0°或者180°旋转，得到另一张多米诺骨牌，找出对应的牌
     * 那么会返回1
     */
    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int count = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            count += num[val];
            num[val]++;
        }
        return count;
    }

}
