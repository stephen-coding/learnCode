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

    public static void bubbleSort(int[] arr){

        //冒泡排序的时间复杂度为O(n*n)
        int temp = 0;//临时变量
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length-1 -j ; i++) {
                if (arr[i] > arr[i+1]){
                    //交换
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}
