package com.life.algorithm;

/**
 * @author T596
 * @date 2024/1/10
 */
public class LeetCode2696 {

    public static int minLength(String s) {

        if (s.contains("AB")) {
            s = s.replaceAll("AB", "");
            return minLength(s);
        }
        if (s.contains("CD")) {
            s = s.replaceAll("CD", "");
            return minLength(s);
        }
        return s.length();
        }


    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(minLength(s));
    }
}
