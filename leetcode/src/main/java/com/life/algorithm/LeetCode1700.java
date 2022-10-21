package com.life.algorithm;

import java.util.Arrays;

public class LeetCode1700 {

    public static int countStudents(int[] students, int[] sandwiches) {

        int[] arr = new int[2];//记录0和1的数量
        for (int student : students) {
            arr[student]++;
        }
        for (int sandwiche : sandwiches) {
            //如果栈顶的食物没有人吃,直接结束循环，如果存在能吃栈顶食物的同学那么一定能够遍历到他
            if (arr[sandwiche] == 0) {
                break;
            }
            arr[sandwiche]--;//吃掉
        }

        return arr[0] + arr[1];
    }

    public static void main(String[] args) {

        int[] st = {1,1,1,0,0,1};
        int[] sa = {1,0,0,0,1,1};
        int[] t = {1,1,0,0};
        int[] a = {0,1,0,1};
        System.out.println(countStudents(st, sa));
    }
}
