package com.life.learn;

import com.life.algorithm.dataStructure.ListNode;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void deleteNode(ListNode node) {

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

    public void common() {

        System.out.println("father");
    }

    static class Son extends Test {

        public void common() {
            System.out.println("son");
        }


    }


    public static void main(String[] args) {

         Son son = new Son();
         son.common();
         Test test = new Son();
         test.common();
         Test test1 = new Test();
         test1.common();


    }


}
