package com.life.algorithm;

import java.util.Arrays;

public class LeetCode1945 {

    /**
     *   easy
     * @param s 只有小写字母的字符串
     * @param k 转换次数
     * @return  输出的和
     */
    public static int getLucky(String s, int k) {
        int sum = 0;
        StringBuilder collect = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            collect.append(num);
        }
        String[] split = collect.toString().split("");
        for (String value : split) {
            sum += Integer.parseInt(value);
        }
        while (k != 1) {
            String[] split1 = Integer.toString(sum).split("");
            sum = 0;
            for (String value : split1) {
                sum += Integer.parseInt(value);
            }
            k--;

        }
        return sum;

    }

    public static void main(String[] args) {
        String s = "jshhskhs";
        int k = 4;
        int lucky = getLucky(s, k);
        System.out.print(lucky);
    }

}
