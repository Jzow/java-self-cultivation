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
 * 统计为偶数的数字
 * 给定一个整数数组nums 返回其中为偶数的数字
 */
public class FindNumbers {

    public static void main(String [] args){
        int [] a = {12,345,2,6,7896};
        System.out.println(findNumbers(a));
    }

    /**
     * 数字循环除以10，统计等于0的时候除以10的次数
     * 最后在拿这些次数除以偶数次，则该数为偶数位
     * @param nums
     * @return
     */
    public static int findNumbers(int [] nums){
        int result = 0;
        if(nums.length == 0){
            return result;
        }
        for (int i = 0; i < nums.length; ++i){
            int count = 0;
            while (nums[i] != 0){
                nums[i] /= 10;
                count++;
            }
            if(count % 2 == 0){
                result++;
            }
        }
        return result;
    }
}
