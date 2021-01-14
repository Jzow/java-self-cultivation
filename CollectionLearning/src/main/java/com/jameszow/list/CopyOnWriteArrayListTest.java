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
package com.jameszow.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ClassName: CopyOnWriteArrayList
 * Description: TODD
 * Author: James Zow
 * Date: 2021/1/6 0006 21:32
 * Version:
 **/
public class CopyOnWriteArrayListTest {

    public static void main(String [] args){
        List<Object> objectList = new CopyOnWriteArrayList<>();
        objectList.add("test");
        objectList.add("tes2");

        objectList.forEach(item -> {
            System.out.println(item);
        });
    }
}
