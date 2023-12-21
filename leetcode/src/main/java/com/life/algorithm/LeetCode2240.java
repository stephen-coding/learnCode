package com.life.algorithm;



/**
 * @author T596
 * @date 2023/9/1
 */
public class LeetCode2240 {

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {

        if (cost1 > total && cost2 > total) {
            return 1;
        }
        int penNum = total / cost1;
        long ans = 0;
        for(int i = 0; i <= penNum; i++){
            int remain = total - cost1 * i;
            ans += remain / cost2 + 1;//剩余钱可买的铅笔方案个数
        }
        return ans;

    }

    public static void main(String[] args) {
        int total = 20;
        int cost1 = 10;
        int cost2 = 5;
        long l = waysToBuyPensPencils(total, cost1, cost2);
    }



}
