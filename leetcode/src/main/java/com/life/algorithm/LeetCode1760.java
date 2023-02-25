package com.life.algorithm;

public class LeetCode1760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 0;
        for(int num : nums) r = Math.max(r, num);
        while(l < r) {
            int mid = l + r >> 1;
            if(ops(nums, mid) <= maxOperations) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public int ops(int[] nums, int maxV) {
        int ret = 0;
        for(int num : nums) ret += (num - 1) / maxV;
        return ret;
    }
}
