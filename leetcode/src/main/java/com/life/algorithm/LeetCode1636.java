package com.life.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1636 {

    //8ms  太慢了 需优化
    public static int[] frequencySort(int[] nums) {

        int[] help = new int[201];
        for (int num : nums) {
            help[num + 100]++;
        }
        // 自定义 sort  如果频率不相等 按频率升序； 如果频率相等 按数值降序;
        return Arrays.stream(nums).boxed()
                .sorted((a,b) -> help[a + 100] != help[b + 100] ? help[a + 100] - help[b + 100] : b - a)
                .mapToInt(n -> n)
                .toArray();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, -1, -1, -1, 5, 5, 8};
        System.out.println(Arrays.toString(frequencySort(nums)));

    }
}
