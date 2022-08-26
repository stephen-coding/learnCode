package com.life.algorithm;

public class LeetCode58 {

    public int lengthOfLastWord(String s) {

        String[] strings = s.split(" ");
        String string = strings[strings.length - 1];
        return string.length();

    }

}
