package com.jameszow.factory;

/**
 * ClassName: UserFactoryTest
 * Description: TODD
 * Author: James Zow
 * Date: 2021/1/6 0006 21:08
 * Version:
 **/
public class UserFactoryTest {

    public static void main(String [] args){
        UserFactory userFactory = new UserFactory.Builder(1)
                .username("zhaowei")
                .password("zw123456")
                .telephone("16621512151")
                .status(1)
                .Builder();

        System.out.println(userFactory);

    }
}
