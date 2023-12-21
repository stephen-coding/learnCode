package com.life.algorithm;

/**
 * Description:
 * User: llf
 * Date: 2023/6/13
 * Time: 11:27
 *
 * @return
 */
public class LeetCode2475 {

    public int unequalTriplets(int[] nums) {

        int length = nums.length;
        int ans = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    int first = nums[i];
                    int second = nums[j];
                    int third = nums[k];
                    if ((first != second) && (first != third) && (second != third)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}


