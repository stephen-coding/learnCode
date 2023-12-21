package com.life.algorithm;

import org.apache.commons.math3.linear.MatrixUtils;

import java.util.Arrays;


/**
 * @author T596
 * @date 2023/7/27
 */
public class LeetCode2500 {

    public static int deleteGreatestValue(int[][] grid) {

        for (int[] ints : grid) {
            Arrays.parallelSort(ints);
        }

        int sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            sum += max;
        }
        return sum;

    }

    public static void main(String[] args) {
        int[][] grid = {{1, 8, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(deleteGreatestValue(grid));
    }


}


