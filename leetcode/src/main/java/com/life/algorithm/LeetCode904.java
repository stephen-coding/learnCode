package com.life.algorithm;

import java.util.HashMap;

public class LeetCode904 {

    public static int totalFruit(int[] fruits) {

        int n = fruits.length, ans = 0;
        int[] cents = new int[n + 10];
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            if (++cents[fruits[i]] == 1) tot++;
            while (tot > 2) {
                if (--cents[fruits[j++]] == 0) tot--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static int totalFruit1(int[] fruits) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 1;
        int n = fruits.length;
        if(n==1) return 1;

        while(right<n){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            right++;
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    public int totalFruit2(int[] fs) {
        int len = fs.length, res = 0;
        //cnts用来统计每种水果树的数量
        int[] cnts = new int[len + 10];
        //i是窗口的右边，j是左边，tot表示当前篮子里水果的种类（至多有两种水果），也表示窗口中的水果种类数量
        for (int i = 0, j = 0, tot = 0; i < len; i++) {
            //表示窗口中第一次出现这种水果，使种类数增加
            //  j    i
            // {3,3,3},1,2,1,1,2,3,3,4
            //  j      i
            // {3,3,3,1},2,1,1,2,3,3,4  增加tot
            if (++cnts[fs[i]] == 1) tot++;
            //当种类数量大于2时，使窗口左侧收缩，并且除去对应的水果种类在cnts中的数量
            //当为0时则彻底在窗口中除去该种水果
            //      j  i
            // 3,3,{3,1},2,1,1,2,3,3,4
            //       j i
            // 3,3,3,{1},2,1,1,2,3,3,4 减少tot
            while (tot > 2) {
                if (--cnts[fs[j++]] == 0) tot--;
            }
            //即时比较判断窗口中水果树的数量，经过前两步窗口中的东西一定是满足题义的
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] f = {3,3,3,1,2,1,1,2,3,3,4};
        int i = totalFruit(f);
        System.out.println(i);
    }
}
