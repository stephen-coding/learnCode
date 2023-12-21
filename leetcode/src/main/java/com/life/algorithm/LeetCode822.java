package com.life.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author T596
 * @date 2023/8/2
 */
public class LeetCode822 {

    public static int flipgame(int[] fronts, int[] backs) {

        Set<Integer> set = new HashSet();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!set.contains(fronts[i])) {
                ans = Math.min(ans, fronts[i]);
            }
            if (!set.contains(backs[i])) {
                ans = Math.min(ans, backs[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;


    }



    public static void main(String[] args) {

        int[] f = {1, 2, 4, 4, 7};
        int[] b = {1, 3, 4, 1, 3};
        System.out.println(flipgame(f, b));
    }
}
