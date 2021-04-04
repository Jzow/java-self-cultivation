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
 * 森林中的兔子
 * 每只兔子有不同的颜色，其中一些兔子（可能是全部兔子）告诉你还有多少只兔子和它有相同的颜色，将这些保存到数组answers中
 * 返回森林中兔子的最少数量
 * 输入 [1,1,2]
 * 输出 5
 */
public class NumRabbits {

    public static void main(String [] args){
        int [] n = {1, 1, 2};
        System.out.println(numRabbits(n));
    }

    /**
     * 贪心算法
     * 设其中颜色的兔子为m只，回答为n
     * 那么得到该颜色的兔子至少有 m = n + 1 只
     * @param answers
     * @return
     */
    public static int numRabbits(int [] answers){
        Arrays.sort(answers);
        int length = answers.length;
        int result = 0;
        for (int i = 0; i < length; ++i){
            int n = answers[i];
            result += n + 1;
            // 跳过[数值n]后面的n个[数值n]
            int k = n;
            while (k-- > 0 && i + 1 < length && answers[i] == answers[i + 1]){
                i ++;
            }
        }
        return result;
    }
}
