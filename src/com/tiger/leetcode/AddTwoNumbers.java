package com.tiger.leetcode;

import java.util.List;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultHead = new ListNode(0);
        ListNode currentNode = resultHead;

        int remain = 0;
        while(l1 != null && l2 != null){
            int nextVal = l1.val + l2.val + remain;
            if(nextVal < 10) {
                remain = 0;
            }
            else{
                remain = 1;
                nextVal = nextVal - 10;
            }
            currentNode.next = new ListNode(nextVal);
            currentNode = currentNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int nextVal = l1.val + remain;
            if(nextVal < 10) {
                remain = 0;
            }
            else{
                remain = 1;
                nextVal = nextVal - 10;
            }
            currentNode.next = new ListNode(nextVal);
            currentNode = currentNode.next;
            l1 = l1.next;
        }

        while (l2 != null){
            int nextVal = l2.val + remain;
            if(nextVal < 10) {
                remain = 0;
            }
            else{
                remain = 1;
                nextVal = nextVal - 10;
            }
            currentNode.next = new ListNode(nextVal);
            currentNode = currentNode.next;
            l2 = l2.next;
        }

        if(remain != 0) currentNode.next = new ListNode(remain);
        return resultHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildList(new int[]{1});
        ListNode l2 = ListNode.buildList(new int[]{9, 9});
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode.printList(solution.addTwoNumbers(l1, l2));

    }
}
