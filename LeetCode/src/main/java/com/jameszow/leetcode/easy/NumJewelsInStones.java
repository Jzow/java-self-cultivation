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

public class NumJewelsInStones {

    public static void main(String [] args){
        System.out.println(numJewelsInStones("aA", "aAAbbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones){
        int result = 0;
        for (int i = 0; i < stones.length(); ++i){
            for(int j = 0; j < jewels.length(); ++j){
              if(stones.charAt(i) == jewels.charAt(j)){
                  result++;
                  break;
              }
            }
        }
        return result;
    }
}
