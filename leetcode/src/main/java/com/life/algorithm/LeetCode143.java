package com.life.algorithm;

import com.life.algorithm.dataStructure.ListNode;

/**
 * @author T596
 * @date 2023/7/31
 */
public class LeetCode143 {

    public void reorderList(ListNode head) {


        ListNode fast = head;
        ListNode slow = head;

        //用快慢指针确定链表中间位置
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        //断开了
        slow.next = null;
        //反转
        secondHalf = reverseList(secondHalf);//后半段链表翻转

        ListNode cur = head;
        while(secondHalf != null) {//前后两段进行拼接
            ListNode next = cur.next;//将当前节点的下一个指针暂存
            cur.next = secondHalf;//当前节点的下一个指针，指向后半段链表（反转后）的头节点
            secondHalf = secondHalf.next;//将后半段的需要插入操作的节点向后移动
            cur = cur.next;//拿出当前节点已拼接的下一个指针
            cur.next = next;//被拼接的部分和之前暂（前半段）存的连接
            cur = cur.next;//将前半段链表的需要被插入的节点向后移动
        }
    }

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
