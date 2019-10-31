package com.example.leetcode.leetcode.Tree.BuildTree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null)
                ((LinkedList<TreeNode>) queue).add(cur.left);
            if (cur.right != null)
                ((LinkedList<TreeNode>) queue).add(cur.right);
        }
        return root;
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
