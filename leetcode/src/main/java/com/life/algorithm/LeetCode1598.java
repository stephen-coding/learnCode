package com.life.algorithm;

public class LeetCode1598 {

    //todo 未解出答案，需改进
    public int minOperations(String[] logs) {

        int nums = 0;
        for (int i = 1; i < logs.length; i++) {

            if (!logs[i].equals("./") && !logs[i].equals("../")) {
                nums++;
            }


        }

        return nums;

    }
}
