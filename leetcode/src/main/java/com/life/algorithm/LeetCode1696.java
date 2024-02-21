package com.life.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author T596
 * @date 2024/2/5
 */
public class LeetCode1696 {

    public int maxResult(int[] nums, int k) {
        //使用双端队列
        Deque<Integer> q = new LinkedList<>();
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        q.add(0);
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + dp[q.peek()];
            while(!q.isEmpty() && dp[q.peekLast()] <= dp[i]) q.pollLast();
            q.addLast(i);
            if(i - k >= 0 && q.peek() == i - k) q.poll();
        }
        return dp[nums.length-1];
    }
}
