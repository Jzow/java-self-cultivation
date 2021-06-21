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

/**
 * This class test BuilderFactory {@link UserFactory}
 * 此类测试UserFactory的封装方法
 */
public class UserFactoryTest {

    public static void main(String [] args){
        UserFactory userFactory = new UserFactory.Builder(1)
                .username("zhaowei")
                .password("zw123456")
                .telephone("16621512151")
                .status(1)
                .Builder();

        System.out.println(userFactory);

        Disease disease = new Disease.Builder(2)
                .diseaseName("脑血栓")
                .diseaseCase("大量脑出血")
                .Builder();

        System.out.println(disease);
    }
}
