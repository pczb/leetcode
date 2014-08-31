package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 * I simulate the qsort method;
 * using three head to record the head of each list ie(the head that's small than the pivot....);
 */
public class MergeList {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode index = head.next;
        ListNode aboveHead = new ListNode(0);
        ListNode belowHead = new ListNode(0);
        head.next = null;
        ListNode aboveIndex = aboveHead ,belowIndex = belowHead,equalIndex = head;
        ListNode tmpIndex;
        while(index != null){
            if(index.val == head.val){
                equalIndex.next = index;
                equalIndex = index;
                index = index.next;
                equalIndex.next = null;
            }
            else if(index.val > head.val){
                aboveIndex.next = index;
                aboveIndex = index;
                index = index.next;
                aboveIndex.next = null;

            }
            else{
                belowIndex.next = index;
                belowIndex = index;
                index = index.next;
                belowIndex.next = null;
            }

        }

        belowHead.next = sortList(belowHead.next);
        index = belowIndex;
        while(index.next != null){
            index = index.next;
            //           System.out.println(index.val+"     z      ");
        }

        index.next = head;
        while(index.next != null){
            index = index.next;
//            System.out.println(index.val+"     x      ");
        }

        index.next = sortList(aboveHead.next);

        return belowHead.next;
    }
}
