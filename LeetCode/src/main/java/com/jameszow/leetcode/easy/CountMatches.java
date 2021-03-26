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

import java.util.List;

/**
 * 统计匹配检索的物品数量
 * 给定一个数组items, items[i] = [type, color, name], 描述第几件物品的类型颜色名称
 * 给定二个字符串ruleKey和ruleValue 表示检索规则
 */
public class CountMatches {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue){
        int result = 0;
        if(items.size() < 0){
            return result;
        }
        // type
        int i = 0;
        if(ruleKey.equals("color")){
            i = 1;
        }else if(ruleKey.equals("name")){
            i = 2;
        }
        for (int j = 0; j < items.size(); ++j){
            if(items.get(j).get(i).equals(ruleValue)){
                result++;
            }
        }
        return result;
    }
}
