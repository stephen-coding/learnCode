package com.life.algorithm;


import java.util.Arrays;

public class LeetCode667 {

    public static int[] constructArray(int n, int k) {
        int[] result = new int[n];
        if (k == 1) {
            int start = 1;
            for (int i = 0; i < n; i++) {
                result[i] = start++;
            }
            return result;
        }
       int start = 1; int temp = k + 1;
       //偶数下标填充原来的数字
        for (int i = 0; i <= k; i = i + 2) {

            result[i] = start;
            start++;
        }
        //奇数下标填写k + 1、 k、  k - 1
        for (int i = 1; i <= k ; i = i + 2) {
            result[i] = temp;
            temp--;
        }

        //k + 1，到  n - 1 顺序填充
        for (int i = k + 1; i < n; i++) {

            result[i] = i + 1;
        }

        return result;

    }

    public static void main(String[] args) {

        int n = 5;
        int k = 2;
        int[] ints = constructArray(5, 2);
        System.out.println(Arrays.toString(ints));


    }
}
