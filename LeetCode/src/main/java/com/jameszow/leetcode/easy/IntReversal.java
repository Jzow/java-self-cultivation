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
 * int reversal algorithm
 * 整数反转算法
 */
public class IntReversal {

    public static void main(String [] args){
        int number = 1534236469;
        int a = 0 * 10 + number % 10;
        int b = number / 10;
        System.out.println(a);
        System.out.println(b);
        System.out.println(reversal(number));
    }

    public static int reversal(int number){
        int result = 0;
        while (number != 0){
            if((result * 10) / 10 != result){
                result = 0;
                break;
            }
            result = result * 10 + number % 10;
            number = number / 10;
        }
        return result;
    }
}
