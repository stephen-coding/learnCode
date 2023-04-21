package com.life.algorithm;

public class LeetCode2413 {

    public int smallestEvenMultiple(int n) {

        if (n % 2 != 0) {

            return n * 2;

        }

        return n;

    }
}
