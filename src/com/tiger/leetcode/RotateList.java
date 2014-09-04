package com.tiger.leetcode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        int listLen = 1;
        ListNode end = head,current = head;
        while(end.next != null) {
            end = end.next;
            listLen += 1;
        }
        end.next = head;

        n = n % listLen;
        for(int i = 1; i < listLen - n; i++)
            current = current.next;

        head = current.next;
        current.next = null;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = ListNodeHelper.buildList();
        RotateList solution = new RotateList();
        head = solution.rotateRight(head, 5);
        ListNodeHelper.printList(head);
    }

}
