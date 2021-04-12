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
import java.util.Arrays;

public class LargestNumber {

    public static void main(String [] args){
        int [] n = {5,53,27,9,16};
        System.err.println(largestNumber(n));
    }

    public static String largestNumber(int [] nums){
        String [] over = new String [nums.length];
        for(int i = 0; i< nums.length; i++){
            over[i] = "" + nums[i];
        }
        Arrays.sort(over, (a, b) -> {
            String left = a + b, right = b + a;
            return right.compareTo(left);
        });

        StringBuffer sbuffer = new StringBuffer();
        for (String item : over){
            sbuffer.append(item);
        }
        int length = sbuffer.length();
        int j = 0;
        while (j < length - 1 && sbuffer.charAt(j) == '0'){
            j++;
        }
        return sbuffer.substring(j);
    }
}
