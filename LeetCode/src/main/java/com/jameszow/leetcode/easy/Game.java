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
 * 猜数字游戏
 * 小A和小B 猜测数字 小B从 1,2,3中随机选一个，小A从1,2,3中选择一个猜，他们一共进行3次游戏
 * 返回小A猜对了几次 数组长度都为3
 * 输入guess = [2,2,3] answer = [3,2,1]
 * 返回1,小A只猜对了第二次
 *
 */
public class Game {

    public static void main(String [] args){
        int [] a = {2, 2, 3};
        int [] b = {3, 2, 1};
        System.out.println(game(a, b));
    }


    public static int game(int [] guess, int [] answer){
        // 判断猜测回答数组长度不能大于3
        int result = 0;
        if(guess.length > 3 && answer.length > 3){
            return result;
        }
        for(int i = 0; i < guess.length; ++i){
            if(guess[i] == answer[i]){
                result++;
            }
        }
        return result;
    }
}
