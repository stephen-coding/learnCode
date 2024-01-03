package com.life.algorithm;

import com.life.algorithm.dataStructure.ListNode;

/**
 * @author T596
 * @date 2024/1/3
 */
public class LeetCode2487 {

    public ListNode removeNodes(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode node = removeNodes(head.next);
        if (node.val > head.val) return node;
        head.next = node;
        return head;
    }
}
