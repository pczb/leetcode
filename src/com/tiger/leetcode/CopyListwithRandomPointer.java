package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode current = head, ansCurrent = null;
        while(current != null) {
            RandomListNode node = new RandomListNode(current.label);
            node.next = current.next;
            current.next = node;
            current = node.next;
        }

        current = head;
        RandomListNode ans = new RandomListNode(0);
        ansCurrent = ans;
        while (current != null) {
            ansCurrent.next = current.next;
            ansCurrent = ansCurrent.next;

            if(current.random != null) {
                ansCurrent.random = current.random.next;
            }
            current.next = current.next.next;
            current = current.next;
        }
        return ans.next;
    }
}
