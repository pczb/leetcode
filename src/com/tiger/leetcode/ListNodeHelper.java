package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class ListNodeHelper {

    public static ListNode buildList(int...array){
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

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next;
        while(current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
