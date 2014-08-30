package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
        next = null;
    }

    public static ListNode buildList(int[] array){
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int i: array){
            current.next = new ListNode(i);
            current = current.next;
        }
        return head.next;
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
