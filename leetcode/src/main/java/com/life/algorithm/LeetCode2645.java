package com.life.algorithm;

/**
 * @author T596
 * @date 2024/1/11
 */
public class LeetCode2645 {

    //将abc想想成1、2、3，本质是多少个严格正序的,例：1 2 2 3 1，有三个1 2、2 3、1
    public static int addMinimum(String word) {

        char[] chars = word.toCharArray();
        int ans = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] <= chars[i - 1]) {
                //必须生成一个新的abc
                ans++;
            }
        }
        ans = ans * 3 - chars.length;
        return ans;
    }

    public static void main(String[] args) {
        String word1 = "b";
        String word2 = "aaa";
        String word3 = "abc";
        String word4 = "aaaabb";
        System.out.println(addMinimum(word1));
        System.out.println(addMinimum(word2));
        System.out.println(addMinimum(word3));
        System.out.println(addMinimum(word4));

    }
}
