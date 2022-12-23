package com.life.algorithm;

public class LeetCode2011 {

    //1ms
    public int finalValueAfterOperations1(String[] operations) {

        int x = 0;
        for (String s : operations) {
            if (s.contains("--")) {
                x--;
            } else {
                x++;
            }
        }
        return x;
    }

    //0ms 具体原因charAt直接从数组取，不需要hash和kmp, 会更快
    public int finalValueAfterOperations2(String[] operations) {

        int x = 0;
        for (String s : operations) {
            if (s.charAt(1) == '-') x--;
            else x++;
        }
        return x;

    }

}
