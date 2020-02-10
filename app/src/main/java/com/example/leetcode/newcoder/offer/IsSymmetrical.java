package com.example.leetcode.newcoder.offer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        return isMirror(pRoot, pRoot);
    }

    private boolean isMirror(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot == null && pRoot1 == null)
            return true;
        if (pRoot == null || pRoot1 == null)
            return false;
        if (pRoot.val != pRoot1.val)
            return false;
        return isMirror(pRoot.left, pRoot1.right) && isMirror(pRoot.right, pRoot1.left);
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
