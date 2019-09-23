package com.example.leetcode.leetcode.Tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 */
public class DiameterOfBinaryTree {
    int length = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        cal(root);
        return length;
    }

    private int cal(TreeNode root) {
        if (root == null)
            return 0;
        int left = cal(root.left);
        int right = cal(root.right);
        length = Math.max(length, left + right);
        return Math.max(left, right) + 1;
    }

    public  class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
