package com.life.algorithm;

import java.util.Arrays;

/**
 * @Author T596
 * @Date 2024/10/9
 */
public class LeetCode88 {

    // O((M+N)Log(M+N))
    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
