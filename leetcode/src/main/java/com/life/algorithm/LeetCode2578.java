package com.life.algorithm;

import java.util.Arrays;

/**
 * @author T596
 * @date 2023/10/9
 */
public class LeetCode2578 {

        public int splitNum(int num) {
            char[] nums = String.valueOf(num).toCharArray();
            Arrays.sort(nums);
            int num1 = 0, num2 = 0;
            int i = 0;
            while (i < nums.length) {
                num1 = num1 * 10 + nums[i] - '0';
                i++;
                if (i < nums.length)
                    num2 = num2 * 10 + nums[i] - '0';
                i++;
            }
            return num1 + num2;
        }

}
