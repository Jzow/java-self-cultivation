package com.jameszow.factory;

/**
 * ClassName: privateUtility
 * Description: TODD
 * Author: James Zow
 * Date: 2020/11/17 0017 22:02
 * Version:
 **/
public class PrivateUtility {

    private PrivateUtility() {
        throw  new AssertionError();
    }
    // 私有构造器,就可以避免实例化
}
