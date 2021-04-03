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
 * 最长公共子序列
 * 给定两个字符串 textA 和 textB，返回这两个字符串的公共子序列
 * 其中子序列意思是代表 在原有的字符串下不改变字符的相对顺序的情况下删除某些字符（也可以不删除字符）后组成新的字符串
 * textA = 'abcde' textB = 'abd'
 * 返回3
 * 最长公共子序列是abd 所以返回3
 */
public class LongestCommonSubsequence {

    public static void main(String [] args){
        System.out.println(longestCommonSubsequence("abcde","abd"));
    }

    /**
     * 利用dp动态规划 解题
     * @param textA
     * @param textB
     * @return
     */
    public static int longestCommonSubsequence(String textA, String textB){
        int m = textA.length() , n = textB.length();
        // +1 是为了补空字符
        int [][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(textA.charAt(i - 1 ) == textB.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
