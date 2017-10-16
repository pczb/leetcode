package com.tiger.leetcode;

import java.util.Random;

/**
 * Created by tigerzhang on 16/8/18.
 */
public class LinkListRandomNode {
    public static class Solution {
        ListNode head;

        Random random;
        ListNode prev;
        private long len = 0;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            prev = head;
            random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            long step = Math.abs(random.nextInt());
            ListNode current = prev;

            while (step > 0){
                step -= 1;
                current = current.next;
                if(len <= 0){
                    len--;
                }
                if(current == null){
                    current = head;
                    if(len <= 0){
                        len = 0 - len;
                    }
                    step = step % len;
                    System.out.println(step);
                }
            }

            prev = current;
            return prev.val;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(0);
            head.next = new ListNode(1);
            head.next.next = new ListNode(2);
            Solution solution = new Solution(head);
            for(int i = 0; i < 20; i++){
                System.out.println(solution.getRandom());
            }
        }
    }
}
