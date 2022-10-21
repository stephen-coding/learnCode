package com.life.algorithm;

import java.util.Arrays;

public class LeetCode1464 {

    //2ms
    public int maxProduct(int[] nums) {

        Arrays.sort(nums);
        return ((nums[nums.length - 2] - 1) * (nums[nums.length - 1] - 1) );


    }

    //0ms
    public static int maxProducts1(int[] nums) {

        int maxNumber = 0;
        int sec_max = 0;
        for (int num : nums) {
            if (num > maxNumber) {
                sec_max = maxNumber;
                maxNumber = num;

            } else {
                if (num > sec_max) {
                    sec_max = num;

                }
            }
        }

        return (maxNumber - 1) * (sec_max - 1);


    }

    public static void main(String[] args) {

        System.out.println(48 >> 5 );
    }
}
