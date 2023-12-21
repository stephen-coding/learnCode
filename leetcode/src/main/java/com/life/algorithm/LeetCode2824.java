package com.life.algorithm;

import java.util.List;

/**
 * @author T596
 * @date 2023/11/24
 */
public class LeetCode2824 {

    public int countPairs(List<Integer> nums, int target) {

        int size = nums.size();
        int ans = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int sum = nums.get(i) + nums.get(j);
                if (sum < target) {
                    ans++;
                }
            }
        }
        return ans;

    }
}
