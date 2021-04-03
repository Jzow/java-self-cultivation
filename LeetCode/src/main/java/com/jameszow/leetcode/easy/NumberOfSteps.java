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
 * 将数字变为0的操作
 * 给一个非负整数，返回将该数字变为0的操作需要多少步骤
 * 如果当前数字是偶数 则 / 2
 * 如果是奇数 - 1；
 * num = 14
 * 例：
 * 14/2 = 7
 * 7 - 1 = 6
 * 6 / 2 = 3
 * 3 - 1 = 2
 * 2 / 2 = 1
 * 1 -1 = 0
 *
 * 则返回6
 */
public class NumberOfSteps {

    public static void main(String [] args){
        System.out.println(numberOfSteps(8));
    }

    public static int numberOfSteps(int nums){
        int result = 0;
        while (nums > 0 ){
            if(nums % 2 == 0){
                nums = nums / 2;
                result ++;
            }else {
                nums = nums - 1;
                result ++;
            }
        }
        return result;
    }
}
