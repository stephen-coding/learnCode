package com.life.algorithm;

import java.util.Arrays;

public class LeetCode1785 {

    public static int minElements(int[] nums, int limit, int goal) {

        long s = 0;
        for (int i : nums) {
            s += i;
        }
        long d = Math.abs(s - goal);
        return (int) ((d + limit - 1) / limit);
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 1};
        int limit = 3;
        int goal = -4;

        int[] nums1 = {2, 2, 2, 5, 1, -2};
        int limit1 = 5;
        int goal1 = 126614243;
        System.out.println(minElements(nums1, limit1, goal1));
        System.out.println(minElements(nums, limit, goal));

    }
}
