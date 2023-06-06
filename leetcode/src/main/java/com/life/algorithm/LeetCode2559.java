package com.life.algorithm;/**
 * Description:
 * User: 15001236724
 * Date: 2023/6/2
 * Time: 16:27
 *
 * @return
 */

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.life.algorithm
 * @className: LeetCode2559
 * @author: llf
 * @description: TODO
 * @date: 2023/6/2 16:27
 * @version: 3.0
 */
public class LeetCode2559 {


        public int[] vowelStrings(String[] words, int[][] queries) {
            int n = words.length;
            boolean[] middle = new boolean[n];
            for (int i = 0; i < n; i++) {
                String word = words[i];
                middle[i] = isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
            }
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + (middle[i - 1] ? 1 : 0);
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int s = queries[i][0];
                int e = queries[i][1];
                ans[i] = preSum[e + 1] - preSum[s];
            }
            return ans;
        }

        public static boolean isVowel(char c) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
                default:
                    return false;
            }
        }

}



