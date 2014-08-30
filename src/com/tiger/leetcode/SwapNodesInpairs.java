package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class SwapNodesInpairs {
    public ListNode swapPairs(ListNode head) {
        ListNode node1 = null, node2 = null;
        if(head == null) return head;
        node1 = head;
        node2 = head.next;
        if(node2 == null) return head;
        ListNode nextHead = node2.next;
        node2.next = node1;
        node1.next = swapPairs(nextHead);
        return node2;
    }
}
