package com.life.algorithm;

public class LeetCode1790 {

    public static boolean areAlmostEqual(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        int n = 0;

        int[] index = new int[2];
        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {
                n++;
                if (n > 2) {
                    return false;
                }
                index[1 & n] = i;
            }

        }
        return s1.charAt(index[0]) == s2.charAt(index[1]) && s1.charAt(index[1]) == s2.charAt(index[0]);
    }

    public static void main(String[] args) {

        String s1 = "aa";
        String s2 = "ac";
        boolean b = areAlmostEqual(s1, s2);
        System.out.println(b);
    }
}
