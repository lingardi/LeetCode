package com.example.leetcode.newcoder.offer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
 * （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    TreeNode ans = null;
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null)
            return ans;
        if (k < 1)
            return ans;
        preOrder(pRoot, k);
        return ans;
    }

    private void preOrder(TreeNode pRoot, int k) {
        if (pRoot == null)
            return;
        preOrder(pRoot.left, k);
        if (k == ++count){
            ans = pRoot;
        }
        preOrder(pRoot.right, k);
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
