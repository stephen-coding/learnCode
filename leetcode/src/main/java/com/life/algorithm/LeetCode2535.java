package com.life.algorithm;

import java.util.Arrays;

/**
 * @Author T596
 * @Date 2024/9/26
 */
public class LeetCode2535 {

    public int differenceOfSum(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        int s = 0;
        for (int num : nums) {
             if (num > 10) {
                 s  += String.valueOf(num)
                         .chars()
                         .map(Character::getNumericValue)
                         .sum();
                 continue;
             }
             s += s;
        }

        return sum + s;
    }
}
