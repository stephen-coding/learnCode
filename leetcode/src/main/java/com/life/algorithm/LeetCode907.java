package com.life.algorithm;

/**
 * @author T596
 * @date 2023/11/27
 */
public class LeetCode907 {

    public static int sumSubarrayMins(int[] arr) {


        int[][] allSubsequences = LeetCode2760.getAllSubsequences(arr);
        int ans = 0;
        for (int[] i : allSubsequences) {
            int sub = Integer.MAX_VALUE;
            for (int j : i) {
                sub = Math.min(sub, j);
            }
            ans += sub;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }
}
