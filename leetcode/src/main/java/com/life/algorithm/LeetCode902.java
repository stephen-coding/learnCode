package com.life.algorithm;

public class LeetCode902 {


    public static int atMostNGivenDigitSet(String[] digits, int n) {

        //将数值n进行分割
        char[] chars = String.valueOf(n).toCharArray();

        int result = 0;
        //n的位数
        int nLength = chars.length;
        //字符数组的长度
        int dLength = digits.length;

        //先对非最高位的排列进行统计
        for (int i = 0; i < nLength; i++) {

            result += Math.pow(dLength, i);
        }

        for (int i = 0; i < nLength; i++) {

            //是否需要对下一位数字进行比较
            boolean next = false;
            for (String digit : digits) {
                char at = digit.charAt(0); //将String转化为char
                //在at小于n的i位情况下，进行全排列
                if (at < chars[i]) {
                    result += Math.pow(dLength, nLength - i - 1);
                } else {
                    if (at == chars[i]) {
                        next = true;
                        break;
                    }
                }
            }
            if (!next) {
                return result;
            }
        }

        return ++result;//如果最后一位依然是需要进行比较，但是最后一位无法向后比较了，所以结果+1
    }

    public static void main(String[] args) {
        String[] digits = {"1", "2", "3", "4"};
        int n = 1000;

        int i = atMostNGivenDigitSet(digits, n);
        System.out.println(i);

    }
}
