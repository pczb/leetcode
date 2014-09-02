package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class SortedListToTree {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode end = head;
        if(head == null) return null;
        return listToBst(head, null);
    }

    public TreeNode listToBst(ListNode head, ListNode end){
        TreeNode root = null;
        ListNode fast = head, slow = head;
        while(fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        root = new TreeNode(slow.val);
        if(head != slow)
            root.left = listToBst(head, slow);

        if(slow.next != end)
            root.right = listToBst(slow.next, end);
        return root;

    }

    public static void main(String[] args) {
        SortedListToTree tree = new SortedListToTree();
        ListNode head = ListNodeHelper.buildList();
        TreeNodeHelper.inTraverse(tree.sortedListToBST(head));
    }
}
