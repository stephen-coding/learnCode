package com.life.algorithm;

public class LeetCode1450 {

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int ans = 0;
        if (startTime.length <= 0 || endTime.length <= 0) {
            return ans;
        }

        for (int i = 0; i < startTime.length; i++) {

            if ((startTime[i] <= queryTime && endTime[i] >= queryTime) ) {
                ans++;
            }

        }

        return ans;

    }

    public static void main(String[] args) {

        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        int queryTime = 4;
        int i = busyStudent(startTime, endTime, queryTime);
        System.out.println(i);



    }

}
