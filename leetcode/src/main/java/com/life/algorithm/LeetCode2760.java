package com.life.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author T596
 * @date 2023/11/16
 */
public class LeetCode2760 {

    //耗时：314ms
    public static int longestAlternatingSubarray(int[] nums, int threshold) {


        int ans = 0;
        int[][] allSubsequences = getAllSubsequences(nums);
        for (int[] list : allSubsequences) {
            int length = list.length;
            int left = 0;
            int right = length - 1;
            boolean first = list[left] % 2 == 0;
            if (!first) continue;
            if (length == 1) {
                if (list[0] <= threshold) {
                    ans = Math.max(ans, 1);
                }
                continue;
            }
            int j  = 0;
            for (int i = 0; i < right; i++) {
                boolean flag = list[i + 1] <= threshold;
                boolean second = list[i] % 2 != list[i + 1] % 2;
                boolean third = list[i] <= threshold;
                if (second && third && flag) {
                    j++;
                    if (j == length - 1) {
                        ans = Math.max(ans, length);
                    }
                } else {
                    break;
                }

            }
        }
        return ans;

    }

    public static int[][] getAllSubsequences(int[] nums) {
        List<int[]> subsequences = new ArrayList<>();

        // 构建连续子序列，并添加到列表中
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int[] subsequence = new int[j - i + 1];
                if (j + 1 - i >= 0) System.arraycopy(nums, i, subsequence, 0, j + 1 - i);
                subsequences.add(subsequence);
            }
        }

        // 转换为int[][]数组返回
        int[][] result = new int[subsequences.size()][];
        for (int i = 0; i < subsequences.size(); i++) {
            result[i] = subsequences.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int threshold = 18;
        System.out.println(longestAlternatingSubarray(nums, threshold));

    }
}
