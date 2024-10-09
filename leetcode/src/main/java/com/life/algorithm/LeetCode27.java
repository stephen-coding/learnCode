package com.life.algorithm;

import java.util.Arrays;

/**
 * @Author T596
 * @Date 2024/10/9
 */
public class LeetCode27 {

    // O(N * log n)
    public int removeElement(int[] nums, int val) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == val) {
                nums[i] = 51;
                result++;
            }
        }

        Arrays.sort(nums);
        return nums.length - result;


    }
}
