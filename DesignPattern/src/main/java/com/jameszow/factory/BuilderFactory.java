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
 * ClassName: BuilderFactory
 * Description: TODD
 * Author: James Zow
 * Date: 2020/11/17 0017 21:10
 * Version:
 **/
public class BuilderFactory {

    private final String name;
    private final String label;
    private final double price;
    private final int number;

    public static class Builder{
        // 常量
        private final String name;
        private final String label;
        // 非常量
        private double price  =   0.0;
        private int number    =   0;

        public Builder(String name, String label){
            this.name = name;
            this.label = label;
        }

        public Builder price (double val){
            price = val ;
            return this;
        }

        public Builder number (int val){
            number = val ;
            return this;
        }

        public BuilderFactory Builder(){
            return new BuilderFactory(this);
        }
    }

    public BuilderFactory(Builder builder){
        name = builder.name;
        label = builder.label;
        price = builder.price;
        number = builder.number;
    }
}
