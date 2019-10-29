package com.example.leetcode.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class TreeToNode {
    static List<TreeNode> list = new ArrayList<>();
    /**
     * 使用List会超出内存限制
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        preorder(root);
        int start = 1;
        while (start < list.size()){
            if (root.left != null)  root.left = null;
            if (root.right != null) root.right = null;
            root.right = list.get(start);
            root = root.right;
            start++;
        }
    }

    private static void preorder(TreeNode root) {
        if (root == null)
            return;
        list.add(root);
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 最后输出的树要求为先序遍历，使用后序遍历将当前节点的右指针指向前一个节点即可
     */
    private TreeNode pre = null;
    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;

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
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(6);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.right = root6;
        flatten(root1);
    }
}
