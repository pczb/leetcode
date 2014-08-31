package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class ListNodePreOrder {

    public static void main(String[] args) {
        TreeNode root = TreeNodeHelper.buildTree(new int[]{1, 2, 3, 4}, 0);
        TreeNodeHelper.preTraverse(root);
        TreeNodeHelper.inTraverse(root);
        System.out.println();

        for(int i: preorderTraversal(root)){
            System.out.print(i + " ");
        }
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return ans;
        else stack.push(root);

        TreeNode node;
        while(!stack.empty()){
            node = stack.pop();
            while(node != null) {
                ans.add(node.val);
                if(node.right != null);
                stack.push(node.right);
                node = node.left;
            }
        }
        return ans;

    }
}
