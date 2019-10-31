package com.example.leetcode.leetcode.Tree.Inorder;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *         3
 *       /  \
 *     5      1
 *    / \    / \
 *   6  2   9  8
 *     /  \
 *   7    4
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * 提示：
 *
 * 给定的两颗树可能会有 1 到 100 个结点。
 */
public class LeafSimilar {
    List<Integer> leaf1 = new ArrayList<>();
    List<Integer> leaf2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        inorder(root1, leaf1);
        inorder(root2, leaf2);
        if (leaf1.size() != leaf2.size())
            return false;
        for (int i = 0; i < leaf1.size(); i++){
            if (leaf1.get(i) != leaf2.get(i))
                return false;
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> leaf) {
        if (root == null)
            return;
        inorder(root.left, leaf);
        if (root.left == null && root.right == null)
            leaf.add(root.val);
        inorder(root.right, leaf);
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
