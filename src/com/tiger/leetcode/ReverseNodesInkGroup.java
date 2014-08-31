package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class ReverseNodesInkGroup {

    public static void main(String[] args) {
        ReverseNodesInkGroup solution = new ReverseNodesInkGroup();
        ListNodeHelper.printList(solution.reverseKGroup(ListNodeHelper.buildList(1, 2, 3), 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode end = head;
        while (end != null) {
            count += 1;
            if (count == k) break;
            end = end.next;
        }
        if (count < k) return head;
        ListNode ret = reverse(head, end, reverseKGroup(end.next, k));
        return ret;
    }


    private ListNode reverse(ListNode start, ListNode end, ListNode nextBlockHead) {
        ListNode pre = nextBlockHead;
        ListNode next = null;
        while (start != end) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        end.next = pre;
        return end;
    }
}
