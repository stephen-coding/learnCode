package com.life.algorithm;


import java.util.Arrays;

public class LeetCode769 {

    public static int maxChunksToSorted(int[] arr) {

        //只要找到前i个数中最大的数等于i的，就说明前面的部分是可以升序之后和后面接上的，此时就切一个块出来，以此类推遍历一遍即可
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if (i == max) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0,  2, 3, 4, 5};
        System.out.println(maxChunksToSorted(arr));
    }
}
