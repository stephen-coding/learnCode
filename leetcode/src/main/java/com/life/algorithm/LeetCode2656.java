package com.life.algorithm;

import java.util.Arrays;

/**
 * @author T596
 * @date 2023/11/15
 */
public class LeetCode2656 {

    public int maximizeSum(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        for (int i = 0; i < k; i++) {
            max += nums[nums.length - 1] + i;

        }
        return max;
    }
}
