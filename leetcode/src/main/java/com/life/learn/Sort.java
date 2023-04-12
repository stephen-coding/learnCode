package com.life.learn;

public class Sort {

    private void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 1; j < nums.length; j++) {

                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;

                }
            }
        }

    }
}
