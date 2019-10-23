package com.example.leetcode.leetcode.Tree.BST;


/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 *
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 */
public class RangeSumBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return sum;
        inorder(root, L, R);
        return sum;
    }

    /**
     * 1. 直接中序遍历一遍
     * 2. 向两个边界值逼近，小于L或者大于R的就不遍历了
     */
    private void inorder(TreeNode root, int l, int r) {
        if (root == null)
            return;
//        inorder(root.left, l, r);
        if (root.val >= l && root.val <= r)
            sum += root.val;
        if (root.val > l)
            inorder(root.left, l, r);
        if (root.val < r)
            inorder(root.right, l, r);
//        inorder(root.right, l ,r);
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
