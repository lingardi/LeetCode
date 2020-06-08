package com.example.leetcode.newcoder.leetcode;

import com.example.leetcode.newcoder.offer.Serialize;

public class MinDepth {
    /**
     * 可以考虑层次遍历的第一个叶子节点
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null){
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
