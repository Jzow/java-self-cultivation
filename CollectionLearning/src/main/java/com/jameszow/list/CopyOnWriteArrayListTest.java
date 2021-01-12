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
