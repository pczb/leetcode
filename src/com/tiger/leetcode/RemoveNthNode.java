package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class RemoveNthNode {
    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode head1 = head;
            ListNode head2 = head;
            for (int i = 0; i < n; i++) {
                head1 = head1.next;
            }
            if (head1 == null) return head.next;
            while (head1.next != null) {
                head1 = head1.next;
                head2 = head2.next;
            }
            head2.next = head2.next.next;
            return head;

        }
    }
}
