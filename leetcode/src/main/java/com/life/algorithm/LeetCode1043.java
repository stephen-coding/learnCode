package com.life.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1043 {

    public static int maxSumAfterPartitioning(int[] arr, int k) {

        int[] ans = new int[arr.length+1];
        for(int i=1; i<=arr.length; i++) {
            int max = arr[i - 1];
            ans[i] = arr[i - 1] + ans[i - 1];
            for(int j = 1; i - j > 0 && j < k; j++){
                max = Math.max(max,arr[i - j - 1]);
                ans[i] = Math.max(ans[i], (j + 1) * max + ans[i - j - 1]);
            }
        }
        return ans[arr.length];

    }

    public static void main(String[] args) {
        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        System.out.println(maxSumAfterPartitioning(arr,4));

    }
}
