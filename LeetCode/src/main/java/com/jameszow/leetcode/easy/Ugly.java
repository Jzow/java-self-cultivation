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
 * 丑数，给一个为正整数的n，判断n是否为丑数，如果是返回true，相反返回false
 * 丑数就是只包含质因数2,3,和/或5的正整数
 */
public class Ugly {

    public static void main(String [] args){
        System.out.println(isUgly(14));
    }

    public static boolean isUgly(int n){
        if(n <= 0){
            return false;
        }
        while (n % 2 == 0){
            n /= 2;
        }
        while (n % 3 == 0){
            n /= 3;
        }
        while (n % 5 == 0){
            n /= 5;
        }
        return n == 1;
    }
}
