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
package com.jameszow.leetcode.easy;

/**
 * 设计一个停车系统
 * 有三种不同大小的车位，大，中，小 分别用数字1，2，3表示
 * 并且一辆车只能停在对应的车尺寸中，如果没有空车位返回false，相反能停入车位返回true
 *
 */
public class ParkingSystem {

    private int big     = 1;
    private int medium  = 2;
    private int small   = 3;

    public static void main(String [] args){
        ParkingSystem parkingSystem = new ParkingSystem(1,1,0);
        parkingSystem.addCar(3);
        parkingSystem.addCar(2);
    }

    public ParkingSystem(int big, int medium, int small){
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType){
        // 大型车位
        if(carType == 1){
            if(big > 0){
                big -- ;
                return true;
            }
        }else if(carType == 2){
            if(medium > 0){
                medium --;
                return true;
            }
        }else if(carType == 3){
            if(small > 0){
                small --;
                return true;
            }
        }
        return false;
    }
}
