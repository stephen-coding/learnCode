package com.life.algorithm;

/**
 * @Author T596
 * @Date 2025/1/14
 */
public class LeetCode3065 {

    public int minOperations(int[] nums, int k) {

        int result = 0;
        for (int num : nums) {
            if (num < k) {
                result++;
            }
        }
        return result;
    }
}