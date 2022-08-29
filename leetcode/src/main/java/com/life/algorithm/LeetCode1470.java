package com.life.algorithm;

public class LeetCode1470 {

    public int[] shuffle(int[] nums, int n) {

        int prefix = 0;
        int suffix = n - 1;
        int[] ints = new int[nums.length];

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                ints[i] = nums[prefix];
            } else {
                ints[i] = nums[suffix];

            }
            prefix++;
            suffix++;

        }

        return ints;


    }


}
