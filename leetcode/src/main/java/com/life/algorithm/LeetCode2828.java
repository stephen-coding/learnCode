package com.life.algorithm;

import java.util.List;

/**
 * @author T596
 * @date 2023/12/20
 */
public class LeetCode2828 {

    public static boolean isAcronym(List<String> words, String s) {
        if (s.length() != words.size()) {
            return false;
        }

        for (int i = 0; i < words.size(); i++) {
            boolean b = s.charAt(i) == words.get(i).charAt(0);
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> words = List.of(new String[]{"apple", "banana"});
        String s = "ab";
        System.out.println(isAcronym(words, s));
    }
}
