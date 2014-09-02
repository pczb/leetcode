package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode prevNode = getMthNode(newHead, m);
        ListNode current = prevNode.next;
        ListNode tail = prevNode.next;
        int count = 1;

        ListNode prev = null;
        ListNode next = null;
        while (count <= (n - m + 1)) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        prevNode.next = prev;
        tail.next = next;

        return newHead.next;
    }

    public ListNode getMthNode(ListNode newHead, int m) {
        for (int i = 1; i < m; i++) {
            newHead = newHead.next;
        }
        return newHead;
    }
}
