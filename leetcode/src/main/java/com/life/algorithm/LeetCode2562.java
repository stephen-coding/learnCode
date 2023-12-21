package com.life.algorithm;

/**
 * @author T596
 * @date 2023/10/12
 */
public class LeetCode2562 {

    public static long findTheArrayConcVal(int[] nums) {

        int length = nums.length;
        String string;
        long integer = 0;
        if (length % 2 == 0) {
            for(int i = 0; i < length/2; i++) {
                string = nums[i] + String.valueOf(nums[length - 1 - i]);
                integer += Integer.parseInt(string);
            }
        } else {
            for(int i = 0; i < length/2; i++) {
                string = nums[i] + String.valueOf(nums[length - 1 - i]);
                integer += Integer.parseInt(string);
            }
            integer += nums[length/2];

        }

        return integer;

    }

    public static void main(String[] args) {

        int[] nums1 = {7,52,2,4};
        int[] nums2 = {5,14,13,8,12};
        System.out.println(findTheArrayConcVal(nums2));
    }
}
