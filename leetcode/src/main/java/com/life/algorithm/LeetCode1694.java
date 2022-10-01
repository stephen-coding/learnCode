package com.life.algorithm;

public class LeetCode1694 {

    public String reformatNumber(String number) {

        String tmp = number.replaceAll("(\\s|-)", "");
        int l = tmp.length();
        StringBuilder sb = new StringBuilder();
        int mod = l % 3;
        for (int i = 0; i < l; i++) {
            sb.append(tmp.charAt(i));
            if (mod == 1) {
                if ((i % 3 == 2 && i < l - 4) || i == l - 3) {
                    sb.append("-");
                }
            } else {
                if (i % 3 == 2 && i < l - 1) {
                    sb.append("-");
                }
            }
        }
        return sb.toString();

    }
}
