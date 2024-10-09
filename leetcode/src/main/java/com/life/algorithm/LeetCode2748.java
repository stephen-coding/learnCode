package com.life.algorithm;

/**
 * @author T596
 * @date 2024/6/20
 */
public class LeetCode2748 {

    public static int countBeautifulPairs(int[] nums) {
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
             for (int j = i + 1; j < length; j++) {

                 if (areCoPrime(nums[i], nums[j])) {
                     result++;
                 }

             }
        }

        return result;

    }

    public static boolean areCoPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // 计算两个数的最大公约数 (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,5,1,4};
        int[] nums2 = {11,21,12};
        int[] nums3 = {31,25,72,79,74};

//        System.out.println(countBeautifulPairs(nums1));
//        System.out.println(countBeautifulPairs(nums2));
        System.out.println(countBeautifulPairs(nums3));
    }
}
