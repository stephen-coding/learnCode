package com.life.algorithm;

import java.util.Arrays;

/**
 * Description:
 * User: llf
 * Date: 2023/6/14
 * Time: 11:06
 *
 * @return
 */
public class LeetCode1375 {

    public  int numTimesAllBlue(int[] flips) {


        int ans = 0;
        int maxValue = 0;
        for (int i = 0; i < flips.length; i++) {
            maxValue = Math.max(maxValue, flips[i]);
            if (i + 1 == maxValue) {
                ans++;
            }
        }

        return ans;
    }

}


