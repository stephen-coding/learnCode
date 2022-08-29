package com.life.algorithm;


public class LeetCode1470 {

    //遍历一遍即可
    public int[] shuffle(int[] nums, int n) {

        int index = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[index++] = nums[i];
            ans[index++] = nums[n + i];
        }
        return ans;


    }


}
