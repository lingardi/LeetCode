package com.example.leetcode.leetcode.Tree.Levelorder;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 */
public class FindBottomLeftValue {
    List<List<Integer>> res = new ArrayList<>();
    public int findBottomLeftValue(TreeNode root) {
        levelorder(root, 0);
        int ans = res.get(res.size() - 1).get(0);
        return ans;
    }

    private void levelorder(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth > res.size() - 1){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(depth).add(root.val);
        levelorder(root.left, depth+1);
        levelorder(root.right, depth+1);
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
