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

import java.util.Deque;
import java.util.LinkedList;

/*
 *
 * @author James Zow
 * @create 2021/3/11
 */
public class FindMaxLength {

    public static void main(String [] args){
        System.out.println(calculator("1*3 + 5"));
    }

    public static int calculator(String s){
        int length = s.length();
        int result = 0;
        int num = 0;
        char preSign = '+';
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < length; ++i){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i))&& s.charAt(i) != ' ' || i == length - 1){
                switch (preSign) {
                    case '+' :
                        deque.push(num);
                        break;
                    case '-' :
                        deque.push(-num);
                        break;
                    case '*' :
                        deque.push(deque.pop() * num);
                        break;
                    default  :
                        deque.push(deque.pop() / num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        while (!deque.isEmpty()){
            result += deque.pop();
        }
        return result;
    }
}
