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
package com.jameszow.factory;

import java.util.regex.Pattern;

/**
 * ClassName: NotCreateObject
 * Description: TODD
 * Author: James Zow
 * Date: 2020/11/18 0018 20:43
 * Version:
 **/
public class NotCreateObject {

    // pattern 实例不可变
    private static final Pattern ROMA =Pattern.compile("^(?=.)M(C<<<330)");

    public static boolean isRomaNumeral(String s){
        return ROMA.matcher(s).matches();
    }
}
