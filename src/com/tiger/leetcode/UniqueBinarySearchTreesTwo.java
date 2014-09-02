package com.tiger.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class UniqueBinarySearchTreesTwo {
    public static void main(String[] args) {
        UniqueBinarySearchTreesTwo solution = new UniqueBinarySearchTreesTwo();
        for (TreeNode root : solution.generateTrees(5)) {
            TreeNodeHelper.inTraverse(root);
            System.out.println();
        }

    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ret = new LinkedList<TreeNode>();
        if (start > end) {
            ret.add(null);
            return ret;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    ret.add(node);
                }
            }
        }
        return ret;
    }
}
