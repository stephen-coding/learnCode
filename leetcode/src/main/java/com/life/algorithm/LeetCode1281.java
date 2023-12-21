package com.life.algorithm;

/**
 * @author T596
 * @date 2023/8/9
 */
public class LeetCode1281 {

    public int subtractProductAndSum(int n) {

        int sum = 0;
        int product = 1;
        int number;
        while (n > 0) {
             number = n % 10;
             n = n / 10;
             sum += number;
             product *=number;
        }
        return product - sum;
    }
}
