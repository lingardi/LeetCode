package com.example.leetcode.leetcode.Tree;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度 2.
 */
public class MinDepth {
    /**
     * 求到叶子节点的最短距离，而不是树的最小深度
     * 终止条件：
     * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
     * 当 root 节点左右孩子都为空时，返回 1
     * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
     * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        //找到了叶子节点
        if (root.left == null && root.right == null)
            return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //左右孩子只有一个为空时，需返回不为空的孩子的最小深度，而不是1
        if (root.left == null || root.right == null)
            return left + right + 1;
        return Math.min(left, right) + 1;
    }

    public class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
