package com.life.algorithm;

import java.util.Arrays;

public class LeetCode1460 {

    public static boolean canBeEqual(int[] target, int[] arr) {

        boolean flag = true;
        if (target.length == 0 && arr.length == 0) {

            return true;
        }

        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i <= target.length - 1; i++) {
            if (target[i] != arr[i]) {

                flag = false;
                break;
            }
        }

        return flag;


    }


    public static void main(String[] args) {
        int[] target = {3, 7, 9};
        int[] arr = {3, 7, 11};
        boolean b = canBeEqual(target, arr);
        System.out.println(b);

    }
}
