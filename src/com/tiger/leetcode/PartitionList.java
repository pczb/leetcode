package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode lcurrent = leftHead, rcurrent = rightHead;
        while(head != null) {
            if (head.val >= x){
                rcurrent.next = head;
                rcurrent = head;
            }else{
                lcurrent.next = head;
                lcurrent = head;
            }
            head = head.next;
        }
        rcurrent.next = null;
        lcurrent.next = rightHead.next;
        return leftHead.next;
    }

    public static void main(String[] args) {
        PartitionList solution  = new PartitionList();
        ListNode head = ListNodeHelper.buildList();
        ListNodeHelper.printList(solution.partition(head, 10));
    }
}
