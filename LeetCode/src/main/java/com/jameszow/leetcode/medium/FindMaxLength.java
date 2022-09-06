package com.jameszow.leetcode.medium;

import java.util.Arrays;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int n  = nums.length;
        int [] sum = new int [n + 1];
        for(int i = 1; i <= n; ++i){
            sum[i] = sum[i - 1] + (nums[i - 1] == 1 ? 1: -1);
        }
        int ans = 0;
        int [] hash = new int [2*n + 1];
        Arrays.fill(hash, -1);
        hash[0 + n] = 0;
        for(int j = 2; j <= n; ++j){
            if(hash[sum[j - 2] + n] == -1){
                hash[sum[j - 2] + n] = j - 2;
            }
            if(hash[sum[j] + n ] != -1){
                ans = Math.max(ans, j - hash[sum[j] + n]);
            }
        }
        return ans;
    }
}
