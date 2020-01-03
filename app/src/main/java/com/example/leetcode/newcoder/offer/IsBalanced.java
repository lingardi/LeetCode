package com.example.leetcode.newcoder.offer;

public class IsBalanced {
    boolean ans = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1)
            ans = false;
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
