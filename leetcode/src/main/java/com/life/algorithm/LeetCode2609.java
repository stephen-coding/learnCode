package com.life.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author T596
 * @date 2023/11/8
 */
public class LeetCode2609 {

    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        int countZero = 0, countOne = 0;
        //从前往后开始扫描， 如果0前面有1，说明是新的开始，先统计前面的平衡数量，然后继续为新的0和1的数量赋新的值
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && countOne != 0) {
                ans = Math.max(ans, 2 * Math.min(countOne, countZero));
                countOne = 0;
                countZero = 1;
            } else if (s.charAt(i) == '1') {
                countOne++;
            } else {
                countZero++;
            }
        }
        ans = Math.max(ans, 2 * Math.min(countOne, countZero));
        return ans;

    }
}
