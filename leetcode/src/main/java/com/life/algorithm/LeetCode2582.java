package com.life.algorithm;

/**
 * @author T596
 * @date 2023/9/26
 */
public class LeetCode2582 {

    public int passThePillow(int n, int time) {

        //结束的时候是走了几步,如果可以整除就说明在0或n
        int end = time % (n-1);
        //如果可以被2整除就是->(正向)   否则<-(反向)
        int step = time / (n - 1);
        if (step % 2 == 0) {
            return 1 + end;
        }
        return n - end;

    }
}
