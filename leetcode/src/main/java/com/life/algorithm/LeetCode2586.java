package com.life.algorithm;

/**
 * @author T596
 * @date 2023/11/7
 */
public class LeetCode2586 {

    public static int vowelStrings(String[] words, int left, int right) {

        char[] chars = new char[5];
        chars[0] = 'a';
        chars[1] = 'e';
        chars[2] = 'i';
        chars[3] = 'o';
        chars[4] = 'u';
        int ans = 0;
        for (int i = left; i <= right; i++) {
            boolean s = false;
            boolean e = false;
            String word = words[i];
            char start = word.charAt(0);
            char end = word.charAt(word.length() - 1);
            for (char c : chars) {
                if (c == start) {
                    s = true;

                }
                if (end == c) {
                    e = true;
                }
                if (s && e) {
                    ans++;
                    break;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
       String[] words = {"are","amy","u"};
       int left = 0;
       int right = 2;
        System.out.println(vowelStrings(words, left, right));
    }
}
