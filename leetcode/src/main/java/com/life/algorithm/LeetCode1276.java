package com.life.algorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * @author T596
 * @date 2023/12/25
 */
public class LeetCode1276 {


    //巨无霸汉堡：4 片番茄和 1 片奶酪
    //小皇堡：2 片番茄和 1 片奶酪
    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {


        List<Integer> list = new ArrayList<>(2);

        //只制作小汉堡预计需消耗的番茄
        int m = 2 * cheeseSlices;

        //实际的番茄和预计的差值
        int n = tomatoSlices - m;
        if (n >= 0 && n % 2 == 0) {
            int big  = n / 2;
            if (cheeseSlices - big >= 0) {
                list.add(0, big);
                list.add(1, cheeseSlices - big);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int tomato = 2385088;
        int cheese = 164763;
        System.out.println(numOfBurgers(tomato, cheese));
    }
}
