package com.life.algorithm;

import com.life.algorithm.dataStructure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author T596
 * @date 2023/9/4
 */
public class LeetCode449 {

    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (String s : arr) {
            stack.push(Integer.parseInt(s));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        int val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right = construct(val, upper, stack);
        root.left = construct(lower, val, stack);
        return root;
    }


    public static void main(String[] args) {
        String s = "[]";
        String substring = s.substring(1, s.length() - 1);
        System.out.println(substring.isBlank());
    }

}
