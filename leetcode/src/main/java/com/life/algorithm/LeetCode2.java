package com.life.algorithm;

import com.life.algorithm.dataStructure.ListNode;

/**
 * @author T596
 * @date 2024/1/2
 */
public class LeetCode2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) l1 = new ListNode(0); //如果链表不存在节点就补充节点，并且将节点值赋0
        if (l2 == null) l2 = new ListNode(0);

        int sum = l1.val + l2.val;
        if (sum > 9) {
            if (l1.next == null) l1.next = new ListNode(0);
            l1.next.val++;
            return new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next));
        }
        return new ListNode(sum, addTwoNumbers(l1.next, l2.next));
    }
}
