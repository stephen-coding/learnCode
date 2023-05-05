package com.life.algorithm;

public class LetCode2432 {

    public int hardestWorker(int n, int[][] logs) {

        int id = 0;
        int ans = 0;
        int temp = 0;
        for (int[] p : logs) {
            int i = p[1] - temp;//差值
            temp = p[1];//记录上一次的值
            if(i > ans) {
                ans = i;
                id = p[0];
            } else if (ans == i) {
                id = Math.min(id, p[0]);
            }
        }
        return id;

    }
}
