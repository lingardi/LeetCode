package com.example.leetcode.newcoder.offer;

public class LastCommonNode {
    static TreeNode ans = null;
    public static TreeNode getLastCommonNode(TreeNode root, TreeNode p1, TreeNode p2) {
        if (root == null)
            return null;
        hasPorQ(root, p1, p2);
        return ans;

    }

    private static boolean hasPorQ(TreeNode root, TreeNode p1, TreeNode p2) {
        if (root == null)
            return false;
        int r = root == p1 || root == p2 ? 1: 0;
        int left = hasPorQ(root.left,p1,p2) ? 1:0;
        int right = hasPorQ(root.right, p1,p2) ? 1:0;
        if (r + left + right >= 2){
            ans = root;
            return true;
        }
        return r + left + right > 0;
    }


    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
