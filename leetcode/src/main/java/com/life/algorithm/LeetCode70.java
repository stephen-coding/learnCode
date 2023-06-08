package com.life.algorithm;


/**
 * @projectName: leetcode
 * @package: com.life.algorithm
 * @className: LeetCode70
 * @author: llf
 * @description: TODO
 * @date: 2023/6/8 9:52
 * @version: 3.0
 */
public class LeetCode70 {

    public static int climbStairs(int n) {
        int[] mem = new int[n + 1];
        return climbStairsHelper(n, mem);
    }

    private static int climbStairsHelper(int n, int[] mem) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (mem[n] > 0) {
            return mem[n];
        }
        mem[n] = climbStairsHelper(n - 1, mem) + climbStairsHelper(n - 2, mem);
        return mem[n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int i = climbStairs(45);
        System.out.println(i);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}


