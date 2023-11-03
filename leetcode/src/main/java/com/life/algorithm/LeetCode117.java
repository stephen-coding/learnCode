package com.life.algorithm;

import com.life.algorithm.dataStructure.Node;

/**
 * @author T596
 * @date 2023/11/3
 */
public class LeetCode117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node levelStart = root;  // 当前层的起始节点

        while (levelStart != null) {
            Node current = levelStart;  // 从当前层的起始节点开始

            Node dummy = new Node();  // 创建一个虚拟节点作为下一层的前驱节点
            Node prev = dummy;  // 指向下一层的前驱节点

            while (current != null) {
                if (current.left != null) {
                    prev.next = current.left;  // 设置前驱节点的 next 指针为左子节点
                    prev = prev.next;  // 更新前驱节点
                }

                if (current.right != null) {
                    prev.next = current.right;  // 设置前驱节点的 next 指针为右子节点
                    prev = prev.next;  // 更新前驱节点
                }

                current = current.next;  // 移动到当前层的下一个节点
            }

            levelStart = dummy.next;  // 移动到下一层的起始节点
        }

        return root;
    }
}
