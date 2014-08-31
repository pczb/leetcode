package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode start = new ListNode(0);
        while (head != null) {
            ListNode pre = start;
            while (pre != null) {
                if (pre.next == null || head.val <= pre.next.val) {
                    ListNode tmpNode = pre.next;
                    pre.next = head;
                    head = head.next;
                    pre.next.next = tmpNode;
                    break;
                }
                pre = pre.next;
            }
        }
        return start.next;
    }

}
