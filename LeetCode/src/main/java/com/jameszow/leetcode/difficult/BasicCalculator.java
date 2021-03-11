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
package com.jameszow.leetcode.difficult;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 实现基本计算器
 * 通过传入一个字符串表达式 需要计算里面的值。
 *
 * input = (1+5)+6-3
 * output = 9
 *
 * @author James Zow
 * @create 2021/3/10
 */
public class BasicCalculator {

    public static void main(String [] args){
        System.out.println(calculator(" (1+5)+ 6 -3"));
    }

    public static int calculator(String s){
        // 创建一个栈
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        // sign为了每个char的数字相乘为1
        int sign = 1;
        // 返回结果数字
        int result = 0;
        int n = s.length();
        int i = 0;
        while (i < n){
            // 判断表达式是否有出现空格
            if (s.charAt(i) == ' '){
                i++;
            }else if(s.charAt(i) == '+'){
                sign = ops.peek();
                i++;
            }else if(s.charAt(i) == '-'){
                sign = -ops.peek();
                i++;
            }else if(s.charAt(i) == '('){
                ops.push(sign);
                i++;
            }else if(s.charAt(i) == ')'){
                ops.pop();
                i++;
            }else {
                long num = 0;
                // 判断字符是否为数字
                while (i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }
}
