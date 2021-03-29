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
 * IP地址无效化
 * 给定一个IP地址 192.168.20.24
 * 无效化就是用"[.]"代替每一个.
 * 输入: 192.168.20.24
 * 输出: 192[.]168[.]20[.]24
 */
public class DefangIPaddr {

    public static void main(String [] args){
        System.out.println(defangIPaddr("192.168.20.24"));
    }

    public static String defangIPaddr(String ip){
        String symbol = "[.]";
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < ip.length(); ++i){
            if(ip.charAt(i) == '.'){
                s.append(symbol);
            }else {
                s.append(ip.charAt(i));
            }
        }
        return String.valueOf(s);
    }
}
