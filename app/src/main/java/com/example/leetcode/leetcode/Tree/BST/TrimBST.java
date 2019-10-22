package com.example.leetcode.leetcode.Tree.BST;

/**
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。
 * 通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
 * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 *
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 * 示例 2:
 *
 * 输入:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * 输出:
 *       3
 *      /
 *    2
 *   /
 *  1
 */
public class TrimBST {
    /**
     * 当前节点小于L时，将右子树递归加入
     * 当前节点大于R时，将左子树递归加入
     * 当前节点满足范围时，将左右子树递归加入
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        TreeNode res = null;
        if (root == null)
            return res;

        if (root.val < L){
            res = trimBST(root.right, L, R);
        }else if (root.val > R){
            res = trimBST(root.left, L, R);
        }else {
            res = new TreeNode(root.val);
            TreeNode l = trimBST(root.left, L, R);
            TreeNode r = trimBST(root.right, L, R);
            res.left = l;
            res.right = r;
        }
        return res;
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
