package com.jameszow.datatype;

/**
 *
 * @author James Zow
 * @create 2021/9/10
 */
public class ByteTest {

    public static void main(String [] args){
        byte b1 = 2;

        // b2 -> 8
        System.out.println("byte二进制位数:" + Byte.SIZE);
        System.out.println("byte最小值:" + Byte.MIN_VALUE);
        System.out.println("byte最大值:" + Byte.MAX_VALUE);

        String s1 = "127";
        System.out.println("字符串s1的byte:" + Byte.parseByte(s1));

    }
}
