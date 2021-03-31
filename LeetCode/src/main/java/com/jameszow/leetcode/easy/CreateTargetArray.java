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


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 按指定顺序创建目标数组
 * 给定两个数组[nums]和[index], 给定一个空的target数组，在target数组的下表index[i]插入nums[i];
 * 重复上一步 直到[nums]和[index]都没有要读取的元素
 * 假设 nums = [5, 7, 9, 1, 10] , index = [0, 1, 1, 2, 3]
 * nums     index       target
 * 5          0          [5]
 * 7          1          [5,7]
 * 9          1          [5,9,7]
 * 1          2          [5,9,1,7]
 * 10         3          [5,9,1,10,7]
 */
public class CreateTargetArray {

    public static void main(String [] args) throws Exception {
        int [] n = {5,7,9,1,10};
        int [] i = {0,1,1,2,3};
        int [] a = Arrays.stream(createTargetArray(n, i)).toArray();
        for (Integer item : a){
            System.out.println(item);
        }
    }

    public static int [] createTargetArray(int [] nums, int [] index) throws Exception {
        if(nums.length < 0 && index.length < 0){
            throw new Exception("数组数据不能为空");
        }
        LinkedList<Integer> resultList = new LinkedList();
        for (int i = 0; i < nums.length; ++i){
            resultList.add(index[i], nums[i]);
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

}
