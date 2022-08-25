package com.life.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode658 {

    //双指针对撞法
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        //原始数组长度
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        //需要从数组中删除的元素个数, 即指针移动的次数
        int moveNums = size - k;
        //开始缩小指针区间，直至满足条件
        while (moveNums > 0) {
            //如果左边大，就把左指针往右移， 剩下小于和等于情况都把右指针往左移
            if (x - arr[left] > arr[right] - x ) {

                left++;

            } else {

                right--;
            }

            moveNums--;


    }

        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right ; i++) {
            list.add(arr[i]);

        }

        return list;

    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int x = 3;
        int k = 4;
        List<Integer> closestElements = findClosestElements(arr, k, x);
        System.out.println(closestElements);
    }
}
