package com.life.algorithm;

import java.math.BigInteger;

public class LeetCode415 {

    public static String addStrings(String num1, String num2) {


        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0) {
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String n = "35434646489876432";
        String m = "99999994694697464946467643143475";
        System.out.println(addStrings(n, m));
    }
}
