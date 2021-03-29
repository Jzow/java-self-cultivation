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
 * 颠倒给定的32位无符号整数的二进制位
 * Java中没有无符号的整数类型
 */
public class ReverseBits {

    private static final int M1 = 0x55555555;
    private static final int M2 = 0x33333333;
    private static final int M4 = 0x0f0f0f0f;
    private static final int M8 = 0x00ff00ff;

    /**
     * 位运算分治法
     * @param n
     * @return
     */
    public static int reverseBits(int n){
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }
}
