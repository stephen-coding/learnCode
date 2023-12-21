package com.life.algorithm;

import java.util.Arrays;

/**
 * @author T596
 * @date 2023/11/10
 */
public class LeetCode2300 {

    //Notice that if a spell and potion pair is successful, then the spell and all stronger potions will be successful too.
    //Thus, for each spell, we need to find the potion with the least strength that will form a successful pair.
    //We can efficiently do this by sorting the potions based on strength and using binary search.
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int left = 0, right = m;
            while (left < right) {
                int mid = (left + right) / 2;
                if ((long) potions[mid] * spells[i] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = m - left;
        }
        return res;
    }

}
