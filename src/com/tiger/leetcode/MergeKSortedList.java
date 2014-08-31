package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode l1 = ListNodeHelper.buildList(2);
        ListNode l3 = ListNodeHelper.buildList(-1);
//        ListNode l4 = ListNode.buildList();
//        ListNode l2 = ListNode.buildList();
        ListNode l5 = null;
        List lists = new ArrayList();
        lists.add(l1);
//        lists.add(l2);
        lists.add(l5);
//        lists.add(l4);
        lists.add(l3);
        ListNodeHelper.printList(mergeKLists(lists));
    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        ListNode[] nodes = new ListNode[lists.size()];
        lists.toArray(nodes);
        int len = nodes.length;
        while (len > 1) {
            int tmp = len / 2;
            int i = 0;
            for (; i < tmp; i++) {
                nodes[i] = merge(nodes[2 * i], nodes[2 * i + 1]);
            }
            if (len % 2 == 1) {
                nodes[i] = nodes[len - 1];
                len = i + 1;
            } else {
                len = i;
            }
        }
        return nodes[0];
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;

        }
        return head.next;
    }
}
