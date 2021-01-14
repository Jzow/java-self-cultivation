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
package com.jameszow.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class uses the console input array for linked operation
 * 此类使用控制台输入数组m进行链接操作
 */
public class LinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class test{
        public static void main(String [] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            // 这里输入 接受[1, 2, 3, 4, 2, 1, 2, 4, 5] 数组格式字符串
            while ((line = in.readLine()) != null){
                ListNode node = LinkedList.stringToListNode(line);
                LinkedList.prettyPrintLinkedList(node);
            }
        }
    }


    public static int[] stringToIntegerArray(String input){
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0){
            return new int[0];
        }

        String [] parts = input.split(",");
        int [] output = new int[parts.length];
        for (int i = 0; i < parts.length; i++){
            String part = parts[i].trim();
            output[i] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input){
        // 从输入参数生成数组
        int [] nodeValues = stringToIntegerArray(input);

        // 将list转换成linked list
        ListNode listNode = new ListNode(0);
        ListNode ptr = listNode;
        for (int item : nodeValues){
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return listNode.next;
    }

    public static void prettyPrintLinkedList(ListNode listNode){
        while (listNode != null && listNode.next != null){
            System.out.println(listNode.val + "->");
            listNode = listNode.next;
        }

        if (listNode != null){
            System.out.println(listNode.val);
        }else {
            System.out.println("empty LinkedList");
        }
    }
}
