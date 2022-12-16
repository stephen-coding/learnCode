package com.life.algorithm;

import java.util.Arrays;

public class LeetCode1785 {

    public static int minElements(int[] nums, int limit, int goal) {

        int count = 0;
        int sum = Arrays.stream(nums).sum();
        if (sum == goal) return 0;
        int temp = sum - goal;
        if (Math.abs(temp) <= limit) return 1;
        int i;
        if (temp >= 0) {
            i = temp - limit;
        } else {

            i = limit - temp;
        }
        count += 2;
        if (i <= limit) return count;
        count = 0;
        while (i > limit) {
            i -= limit;
            count++;
        }
        return count;
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
