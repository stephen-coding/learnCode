package com.life.algorithm;

import java.util.Arrays;

/**
 * @author T596
 * @date 2023/9/5
 */
public class LeetCode2605 {

    public static int minNumber(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    return num1;
                }
            }
        }
        if (nums1[0] > nums2[0]) {

            return 10*nums2[0] + nums1[0];
        } else {

            return nums1[0]*10 + nums2[0];
        }

    }

}
