package com.life.algorithm;

/**
 * @author T596
 * @date 2023/12/29
 */
public class LeetCode2706 {

    public static int buyChoco(int[] prices, int money) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++ ) {
            for (int j = i + 1; j < prices.length; j++) {
                min = Math.min(prices[i] + prices[j], min);
            }
        }
        if (min <= money) {
            return money - min;
        }
        return money;
    }

    public static void main(String[] args) {
        int[] prices = {69,91,78,19,40,13};
        int money = 94;
        System.out.println(buyChoco(prices, money));
    }
}
