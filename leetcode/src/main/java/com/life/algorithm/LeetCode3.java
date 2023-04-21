package com.life.algorithm;

import java.util.HashSet;

public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> hashSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int length = 0;

        for (right = 0; right < s.length(); right++) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
            } else {
                while (hashSet.contains(s.charAt(right))) {
                    length = Math.max(right, hashSet.size());
                    hashSet.remove(s.charAt(right));
                    left++;
                }
                hashSet.add(s.charAt(right));
            }


        }
        return Math.max(length, hashSet.size());
    }

    public static void main(String[] args) {
        System.out.println(2<<3);
    }
}
