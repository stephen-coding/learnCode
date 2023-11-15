package com.life.algorithm;

/**
 * @author T596
 * @date 2023/11/6
 */
public class LeetCode318 {

    public int maxProduct(String[] words) {
        int maxProduct = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasCommonLetters(words[i], words[j])) { // 如果两个单词没有共同的字母
                    int product = words[i].length() * words[j].length();
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }

        return maxProduct;
    }

    // 辅助函数：检查两个单词是否有共同的字母
    private boolean hasCommonLetters(String word1, String word2) {
        for (char c : word1.toCharArray()) {
            if (word2.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
