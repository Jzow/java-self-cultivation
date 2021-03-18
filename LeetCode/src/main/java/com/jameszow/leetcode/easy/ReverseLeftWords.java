package com.jameszow.leetcode.easy;

public class ReverseLeftWords {

    public static void main(String [] args){
        System.out.println(reverseLeftWords("abckkias",3));
    }

    public static String reverseLeftWords(String s, int n){
        int length = s.length();
        StringBuffer result = new StringBuffer();
        for (int i = n; i < length; ++i){
            result.append(s.charAt(i));
        }
        for (int j = 0; j < n; ++j){
            result.append(s.charAt(j));
        }
        return result.toString();
    }


}
