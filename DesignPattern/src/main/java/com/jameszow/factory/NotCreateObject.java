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
