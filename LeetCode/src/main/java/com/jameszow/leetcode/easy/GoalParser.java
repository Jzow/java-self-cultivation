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
 * 设计一个Goal解析器，可以解析command命令，
 * Goal会将command按照顺序解析
 * G     ->  G
 * ()    ->  o
 * (al)  ->  al
 *
 * 输入: G()()()()(al)()
 * 输出: Gooooalo
 */
public class GoalParser {

    public static void main(String [] args){
        System.out.println(parser("G()()()()(al)()"));
    }

    public static String parser(String command){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < command.length(); ++i){
            if(command.charAt(i) == '('){
                if(command.charAt(i + 1) == ')'){
                    sb.append('o');
                    i++;
                    continue;
                }else{
                    sb.append("al");
                    i += 3;
                    continue;
                }
            }
            sb.append('G');
        }
        return sb.toString();
    }
}
