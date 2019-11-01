package com.example.leetcode.leetcode.Tree.Backorder;

import java.util.Collections;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class LongestUnivaluePath {
    private static int res = 0;

    public static int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        travel(root);

        return res;
    }

    /**
     * 对于一个节点的父节点，该节点其返回值应当是左子树和右子树的最大一条，否则无法形成路径
     * @param root
     * @return
     */
    private static int travel(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        int left = travel(root.left);
        int right = travel(root.right);
        System.out.println("root:"+root.val);
        if (root.left != null && root.val == root.left.val){
            left ++;
            System.out.println("ans:"+ans);
        }else {
            left = 0;
        }
        if (root.right != null && root.val == root.right.val){
            right ++;
            System.out.println("ans:"+ans);
        }else {
            right = 0;
        }
        //不断更新最大值
        res = Math.max(res, left + right);

        return Math.max(left, right);
    }

    public static class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(4);
        TreeNode root8 = new TreeNode(4);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;
        root2.right = root5;
        root3.left = root6;
        root6.left = root7;
        root4.right = root8;
        longestUnivaluePath(root);
    }
}
