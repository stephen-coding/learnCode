package com.life.algorithm;

import java.util.HashMap;

/**
 * @author T596
 * @date 2023/9/25
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{0};
    }
}


