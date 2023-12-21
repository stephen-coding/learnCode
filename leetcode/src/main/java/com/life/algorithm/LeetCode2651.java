package com.life.algorithm;

/**
 * @author T596
 * @date 2023/9/8
 */
public class LeetCode2651 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {

        int time;
        time= arrivalTime + delayedTime;
        if (time < 24) return time;
        while (time >= 24) {
            time -= 24;
        }
        return time;



    }
}
