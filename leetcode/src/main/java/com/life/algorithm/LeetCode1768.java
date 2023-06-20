package com.life.algorithm;

public class LeetCode1768 {

    public static String mergeAlternately(String word1, String word2) {

        String substring;
        if (word1.length() >= word2.length()) {

            substring = word1.substring(word2.length());
            word1 = word1.substring(0, word2.length());
        } else {
            substring = word2.substring(word1.length());
            word2 = word2.substring(0, word1.length());
        }
        char[] firstString = word1.toCharArray();
        char[] secondString = word2.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < firstString.length; i++) {
            builder.append(firstString[i]).append(secondString[i]);
        }

        return builder.append(substring).toString();


    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "efg";
        String s = mergeAlternately(word1, word2);
        System.out.println(s);
    }
}
