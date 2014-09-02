package com.tiger.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class BinaryTreeLevelTraverseOne {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode magic = new TreeNode(0);
        queue.offer(root);
        queue.offer(magic);
        List<Integer> list = new LinkedList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == magic){
                ans.add(list);
                if(queue.size() != 0)
                    queue.offer(magic);
                list = new LinkedList<Integer>();
            }else{
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                list.add(node.val);
            }
        }
       // Collections.reverse(ans);
        return ans;
    }
}
