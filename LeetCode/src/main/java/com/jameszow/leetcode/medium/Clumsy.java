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

import java.util.Deque;
import java.util.LinkedList;

/**
 * 笨阶乘
 * 通常n的阶乘 是所有小于或等于n的正整数乘积 比如 num(10)= 10*9*8*7*6*5*4*3*2*1
 * 相反设计一个按照整数递减序把原来的*符号依次替换成 * / + -
 * 例子
 * 输入 7
 * 7 = 7 * 6 / 5 + 4 - 3 * 2 / 1
 * 输出 6
 */
public class Clumsy {

    public static void main(String [] args){
        System.out.println(clumsy(7));
    }

    public static int clumsy(int n) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(n);
        // index表示乘除加减
        int index = 0;
        n--;
        while(n > 0){
            // 乘
            if(index % 4 == 0){
                stack.push(stack.pop() * n);
                // 除
            }else if (index % 4 == 1){
                stack.push(stack.pop() / n);
                // 加
            } else if (index % 4 == 2){
                stack.push(n);
                // 减
            } else {
                stack.push(-n);
            }
            index++;
            n--;
        }
        // 把所有元素从栈中取出来求和
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
