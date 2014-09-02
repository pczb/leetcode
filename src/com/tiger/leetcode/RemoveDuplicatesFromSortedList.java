package com.tiger.leetcode;

import java.util.HashSet;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        HashSet<Integer> used = new HashSet<Integer>();

        ListNode prev = head;
        ListNode current = head;
        used.add(current.val);


        while(current != null) {
            if(!used.contains(current.val)) {
                prev.next = current;
                prev = current;
                used.add(current.val);
            }
            current = current.next;
        }
        prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeHelper.buildList(1,1,2,2,3,4,5,6,7,7);
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        ListNodeHelper.printList(solution.deleteDuplicatesTwo(head));
    }

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
