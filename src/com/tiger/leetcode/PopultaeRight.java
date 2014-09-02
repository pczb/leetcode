package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class PopultaeRight {
    public void connect(TreeLinkNode root) {
        connect1(root);
    }

    private void connect1(TreeLinkNode first) {
        while (first != null) {
            while (first.left == null && first.right == null) {
                first = first.next;
                if (first == null) return;
            }

            TreeLinkNode preNode;
            TreeLinkNode nextFirst;
            if (first.left != null && first.right != null) {
                nextFirst = first.left;
                nextFirst.next = first.right;
                preNode = first.right;
            } else {
                nextFirst = first.left != null ? first.left : first.right;
                preNode = nextFirst;
            }
            first = first.next;
            while (first != null) {
                if (first.left != null) {
                    preNode.next = first.left;
                    preNode = preNode.next;
                }
                if (first.right != null) {
                    preNode.next = first.right;
                    preNode = preNode.next;
                }
                first = first.next;
            }
            first = nextFirst;
        }
    }
}
