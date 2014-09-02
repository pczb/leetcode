package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class MergeTwoSortedArrayList {
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode index = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    index.next = l1;
                    index = l1;
                    l1 = l1.next;
                } else {
                    index.next = l2;
                    index = l2;
                    l2 = l2.next;
                }
            }
            if (l1 != null) index.next = l1;
            if (l2 != null) index.next = l2;
            return head.next;
        }
    }
}
