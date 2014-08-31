package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);

        ListNode lcurrent = head, rcurrent = fast, lnext, rnext;
        while (rcurrent != null) {
            lnext = lcurrent.next;
            rnext = rcurrent.next;
            lcurrent.next = rcurrent;
            rcurrent.next = lnext;
            lcurrent = lnext;
            rcurrent = rnext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
