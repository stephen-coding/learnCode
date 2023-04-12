package com.life.algorithm;

public class LeetCode1147 {

    public static int longestDecomposition(String text) {

        int ans = 0;
        int pre = text.length() - 1;
        int head = 0;
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        while (pre != -1) {

            s1.append(text.charAt(head));
            s2.insert(0, text.charAt(pre));
            head++;
            pre--;
            if (s1.toString().equals(s2.toString())) {
                ans++;
                s1 = new StringBuffer();
                s2 = new StringBuffer();
            }

        }
        return ans;

    }


    public static void main(String[] args) {
        String  text = "ghiabcdefhelloadamhelloabcdefghi";
        longestDecomposition(text);

    }
}
