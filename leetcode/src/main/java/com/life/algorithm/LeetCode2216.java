package com.life.algorithm;

/**
 * @author T596
 * @date 2023/11/21
 */
public class LeetCode2216 {

    public static int minDeletion(int[] nums) {

        int length = nums.length;
        if(length == 0) {
            return 0;
        }

        int ans = 0;
        //模拟被删除元素后，下标的变化
        int index = 0;
        //删除相等相邻元素
        for (int i = 0; i < length - 1; i++) {
            if(index % 2 == 0) {

                if (nums[i] == nums[i + 1]) {
                    ans++;
                    index--;
                }
            }
            index++;
        }
        //最终如果是奇数，删除最后一个元素
        if ((length - ans) % 2 != 0) {
            ans++;
        }
        return ans;

    }

    public static void main(String[] args) {

        int[] nums = {2,8,1,0,4,4,7,0,4,5,1,2,4,1};
        System.out.println(minDeletion(nums));
    }

}
