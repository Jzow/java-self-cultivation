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
 * ClassName: UserFactory
 * Description: TODD
 * Author: James Zow
 * Date: 2021/1/6 0006 20:57
 * Version:
 **/
public class UserFactory {

    private final int id;
    private final String username;
    private final String password;
    private final String telephone;
    private final int status;

    public UserFactory(Builder builder) {
       id = builder.id;
       username = builder.username;
       password = builder.password;
       telephone = builder.telephone;
       status = builder.status;
    }

    public static class Builder{

        private final int id;

        private String username;
        private String password;
        private String telephone;
        private int status;

        public Builder(int id) {
            this.id = id;
        }

        public Builder username(String val){
            username = val;
            return this;
        }

        public Builder password(String val){
            password = val;
            return this;
        }

        public Builder telephone(String val){
            telephone = val;
            return this;
        }

        public Builder status(int val){
            status = val;
            return this;
        }

        public UserFactory Builder(){
            return new UserFactory(this);
        }
    }
}
