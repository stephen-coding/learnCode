package com.life.algorithm;

/**
 * @author T596
 * @date 2023/9/22
 */
public class LeetCode2591 {

    public static int distMoney(int money, int children) {


        int ans = 0;
        int children1 = children;
        int surplus = money - children;
        if (surplus < 0) {
            return -1;
        }
        if (surplus < 7) {
            return ans;
        }
        for (int i = 0; i < children1; i++) {
            surplus -= 7;
            children--;
            if (children == 1 && surplus == 3) {
                break;
            }
            ans++;
            if (surplus < 7) {
                break;
            }
            if (children == 1 && surplus > 7) break;
        }


        return ans;
    }

    public static void main(String[] args) {
        int money = 12;
        int children = 2;
        System.out.println(distMoney(money, children));
    }
}
