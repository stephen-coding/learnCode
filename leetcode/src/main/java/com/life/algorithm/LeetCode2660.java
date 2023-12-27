package com.life.algorithm;

/**
 * @author T596
 * @date 2023/12/27
 */
public class LeetCode2660 {
    public  int isWinner(int[] player1, int[] player2) {

        int p1 = sum(player1);
        int p2 = sum(player2);
        if (p1 == p2) return 0;
        return p1 > p2 ? 1 : 2;

    }

    private int sum(int[] arr) {

        int score = 0;
        int buff = 0;
        for (int i : arr) {
            score += buff > 0 ? i << 1 : i;
            if (i == 10) {
                buff = 2;
            } else {
                buff--;
            }
        }
        return score;
    }


}
