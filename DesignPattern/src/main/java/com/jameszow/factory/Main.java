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
 * This class test BuilderFactory {@link BuilderFactory}
 * Main测试工厂封装方法
 */
public class Main {

    public static void main(String[] args) {
      //  sum();
      //  sum2();
        runExample();
    }

    public static void runExample() {
        BuilderFactory builder = new BuilderFactory.Builder("192.160.20.24", "root")
                .number(1)
                .price(5000.00)
                .Builder();
        System.out.println(builder);

        // 无法实例化 privateUtility a = new privateUtility();
        Enum<AbstractMethod.Type> a = AbstractMethod.Type.beef;
        System.out.println(a);

        // 避免创建不必要的对象

        NotCreateObject.isRomaNumeral("ssssss");
    }

    /**
     * 对比sum和sum2的速度
     * 优先使用long基本类型 而不是Long装箱类型
     * @return
     */
    public static long sum(){
        Long sum = 0L;
        for (long i=0; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }

    public static long sum2(){
        long sum = 0L;
        for (long i=0; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }
}
