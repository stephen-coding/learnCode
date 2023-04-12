package com.life.algorithm;

import com.life.algorithm.dataStructure.ListNode;

public class LeetCode206 {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNode = curr.next; //将当前节点的下一个指针暂存
             curr.next = pre; //将当前节点指针反转
             pre = curr; //指针向前移动
             curr = tempNode; //当前节点向前移动

        }
        return pre;


    }
}
