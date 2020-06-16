package com.example.leetcode.leetcode.Tree;

/**
 *设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 */
public class InorderSuccessor {
    TreeNode ans = null;
    boolean flag;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        inorderSuccessor(root.left, p);
        if (root == p){
            flag = true;
        }else if (flag){
            ans = root;
            flag = false;
        }
        inorderSuccessor(root.right, p);
        return ans;
    }

    public static class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
