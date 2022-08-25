package com.life.algorithm;

import java.util.Arrays;

public class LeetCode1460 {

    //直接法，时间复杂度太高  3ms
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


    //第一次优化   1ms 直接记录相同数字出现的次数，然后再对比数字出现的次数进行减法，从而确定两个数组内的数字是否一样
    public static boolean canBeEqual1(int[] target, int[] arr) {

        if (target.length == 0 && arr.length == 0) {

            return true;
        }
        int[] temp = new int[10001];
        for (int i : target) {
            temp[i]++;

        }
        for (int j : arr) {
            temp[j]--;
            if (temp[j] < 0) {
                return false;
            }

        }
        return true;
    }




    public static void main(String[] args) {
        int[] target = {3, 7, 9};
        int[] arr = {3, 7, 11};
        boolean b = canBeEqual1(target, arr);
        System.out.println(b);

    }
}
