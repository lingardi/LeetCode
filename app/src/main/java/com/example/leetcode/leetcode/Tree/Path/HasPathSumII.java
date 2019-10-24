package com.example.leetcode.leetcode.Tree.Path;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class HasPathSumII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        helper(root, sum, path);
        return ans;
    }

    private void helper(TreeNode root, int sum, List<Integer> path) {
        if (root == null)
            return;
        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == 0){
                ans.add(new ArrayList<>(path));
            }
        }else {
            helper(root.left, sum, path);
            helper(root.right, sum, path);
        }

        path.remove(path.size() - 1);
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
