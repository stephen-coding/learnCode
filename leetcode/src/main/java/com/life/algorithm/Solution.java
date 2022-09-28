package com.life.algorithm;

public class Solution {

    //面试题 消失的两个数字
    public int[] missingTwo(int[] nums) {

         // 首先算出完整版数组的总和，残缺版数组的总和
        int numLength = nums.length + 2;
        int sumAll = numLength * (numLength + 1) / 2;
        int sum = 0;
        for (int num : nums) {

            sum += num;
        }
        //消失两个数的和 x + y = sumAll - sum
        int sumTwo = sumAll - sum;
        //对差值进行对半计算，那么x,y必然有一个值是小于计算后的对半值
        int mid = sumTwo / 2;
        //同样使用对半值未基准，通过两个数组求和，得出差值即为x或者y
        sumAll = (mid + 1) * mid / 2;
        sum = 0;
        for (int num : nums) {
            if (num <= mid) {
                sum += num;
            }
        }
        int num1 = sumAll - sum;
        //得到其中一值，再根据第一步的差值和，即可得出另外值
        int num2 = sumTwo - num1;
        return new int[] {num1, num2};
    }

    //判断两个字符串，经过重排后是否相等
    public boolean CheckPermutation(String s1, String s2) {

        if(s1.length() != s2.length()) {
            return false;
        }
        int[] alphabet = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            alphabet[s1.charAt(i)]++;
            alphabet[s2.charAt(i)]--;
        }
        for (int n : alphabet) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
