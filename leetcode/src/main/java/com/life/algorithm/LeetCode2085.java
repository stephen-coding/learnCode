package com.life.algorithm;

import java.util.*;

/**
 * @author T596
 * @date 2024/1/12
 */
public class LeetCode2085 {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> countMap1 = new HashMap<>();
        Map<String, Integer> countMap2 = new HashMap<>();
        int result = 0;

        // 统计第一个数组中每个字符串出现的次数
        for (String word : words1) {
            countMap1.put(word, countMap1.getOrDefault(word, 0) + 1);
        }

        // 统计第二个数组中每个字符串出现的次数
        for (String word : words2) {
            countMap2.put(word, countMap2.getOrDefault(word, 0) + 1);
        }

        // 遍历第一个数组中的字符串，检查是否在两个数组中都恰好出现一次
        for (String word : words1) {
            if (countMap1.get(word) == 1 && countMap2.getOrDefault(word, 0) == 1) {
                result++;
            }
        }

        return result;
    }
}
