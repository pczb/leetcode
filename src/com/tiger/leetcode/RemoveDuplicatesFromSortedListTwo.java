package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicatesTwo(ListNode head) {
        ListNode ret = new ListNode(0);
        ListNode retCurrent = ret;
        int prevValue = Integer.MAX_VALUE;
        ListNode current = head;
        while(current != null) {
            if(current.next != null && current.val == current.next.val){
                prevValue = current.val;
            }
            if(current.val != prevValue) {
                retCurrent.next = current;
                retCurrent = retCurrent.next;
            }
            current = current.next;
        }
        retCurrent.next = null;
        return ret.next;
    }
}
