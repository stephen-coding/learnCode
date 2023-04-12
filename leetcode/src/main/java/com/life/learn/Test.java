package com.life.learn;

import com.life.algorithm.dataStructure.ListNode;

import java.util.Arrays;
import java.util.List;

public class Test {

    public void deleteNode(ListNode node) {

        ListNode listNode = new ListNode();
        ListNode num = null;
        while (listNode.next != null) {
            if (listNode.next.val == node.val) {
                listNode.next = num;
            }

            listNode =listNode.next;
            num = listNode.next;
        }


    }


    public static void main(String[] args) {


    }


}
