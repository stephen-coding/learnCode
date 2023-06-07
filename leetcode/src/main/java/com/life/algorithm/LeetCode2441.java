package com.life.algorithm;

public class LeetCode2441 {

    public static int findMaxK(int[] nums) {

        int[] zhengshu = new int[1001];
        int[] fushu = new int[1001];

        for (int num : nums) {
            if (num>0){
                zhengshu[num] = 1;
            }else {
                fushu[Math.abs(num)] = -1;
            }
        }

        for (int i = 1000; i > 0; i--) {
            if (zhengshu[i]==0){
                continue;
            }

            if (zhengshu[i]+fushu[i]==0){
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {-1,10,6,7,-7,1};
        findMaxK(nums);
    }
}
