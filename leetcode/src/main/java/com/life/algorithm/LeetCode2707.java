package com.life.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author T596
 * @date 2024/1/9
 */
public class LeetCode2707 {

    public static int minExtraChar(String s, String[] dictionary) {
        // 将字典转换为集合，方便快速查找
        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));

        int size = s.length();
        int[] code = new int[size + 1];
        code[0] = 0;

        for (int i = 1; i <= size; ++i) {
            code[i] = code[i - 1] + 1; // 初始化为默认情况下需要添加一个额外字符

            for (int j = 0; j < i; ++j) {
                // 判断当前子串是否在字典中存在
                if (dictionarySet.contains(s.substring(j, i))) {
                    code[i] = Math.min(code[i], code[j]); // 如果存在，则更新当前位置剩余的字符数量
                }
            }
        }

        return code[size]; // 剩余未操作字符的数量
    }

    public static void main(String[] args) {

        String s = "dwmodizxvvbosxxw";
        String[] ss = {"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"};
        System.out.println(minExtraChar(s, ss));
    }
}
