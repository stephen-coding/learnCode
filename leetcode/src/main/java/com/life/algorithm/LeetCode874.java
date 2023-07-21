package com.life.algorithm;

import java.util.HashSet;
import java.util.Set;

public class LeetCode874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int l = 0, dir = 0;       //len存储最终结果，dir表示行进方向，北0、东1、南2，西3；
        Set<Integer> set = new HashSet<Integer>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int x = 0, y = 0;
        for (int c : commands) {
            if (c == -1) {        //右转
                dir = (dir + 1) % 4;
            }
            if (c == -2) {        //左转
                dir = (dir + 3) % 4;
            }
            if (c <= 9 && c >= 1) {
                if (dir == 0) {    //向北
                    for (int i = 0; i < c && !set.contains(x * 60001 + y + 1); i++) {
                        y++;
                        if (l < x * x + y * y) l = x * x + y * y;
                    }
                }
                if (dir == 1) {    //向东
                    for (int i = 0; i < c && !set.contains((x + 1) * 60001 + y); i++) {
                        x++;
                        if (l < x * x + y * y) l = x * x + y * y;
                    }
                }
                if (dir == 2) {    //向南
                    for (int i = 0; i < c && !set.contains(x * 60001 + y - 1); i++) {
                        y--;
                        if (l < x * x + y * y) l = x * x + y * y;
                    }
                }
                if (dir == 3) {   //向西
                    for (int i = 0; i < c && !set.contains((x - 1) * 60001 + y); i++) {
                        x--;
                        if (l < x * x + y * y) l = x * x + y * y;
                    }
                }
            }
        }
        return l;
    }
}
