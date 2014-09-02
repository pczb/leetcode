package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class ConstructTreeInPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int[] in, int s1, int e1, int s2, int e2) {
     //   System.out.println(s1 + " " + e1);
        if(s1 > e1) return null;
        TreeNode root = null;
        root = new TreeNode(pre[s1]);
        int i = s2;
        for(; i <= e2; i++) {
            if(in[i] == pre[s1])
                break;
        }
        root.left = build(pre, in, s1 + 1, s1 -s2 + i, s2, i - 1);
        root.right = build(pre, in, s1 + 1 +i -s2, e1, i + 1, e2);
        return root;
    }

    public static void main(String[] args) {
        ConstructTreeInPre pre = new ConstructTreeInPre();
        TreeNode root = pre.buildTree(new int[]{}, new int[]{});
        TreeNodeHelper.inTraverse(root);
    }
}
