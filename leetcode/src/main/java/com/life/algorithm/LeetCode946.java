package com.life.algorithm;

import org.yaml.snakeyaml.util.ArrayStack;

import java.util.ArrayDeque;
import java.util.Stack;

public class LeetCode946 {

    //对栈的理解不够深刻，写的慢，想的慢  3ms
    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int k : pushed) {
            stack.push(k);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                ++j;
                stack.pop();

            }

        }

        //todo 不使用stack可以进行优化，用数组模拟入栈和弹出，有时间写一下

        return stack.isEmpty();

    }


    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));

    }
}
