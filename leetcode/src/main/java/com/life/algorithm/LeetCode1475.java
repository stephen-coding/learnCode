package com.life.algorithm;

import java.util.Arrays;

public class LeetCode1475 {

    public static int[] finalPrices(int[] prices) {

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;

                }

            }


        }

        return prices;
    }

    public static void main(String[] args) {

        int[] prices = {10, 20, 3, 2, 1};
        System.out.println(Arrays.toString(finalPrices(prices)));



    }
}
