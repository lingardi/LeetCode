package com.example.leetcode.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;
        levelOrder(root, 0, ans);
        for (List<Integer> list : ans){
            double average = getAverage(list);
            res.add(average);
        }
        return res;
    }

    private double getAverage(List<Integer> list) {
        double sum = 0;
        for (Integer t : list){
            sum += t;
        }
        return sum / list.size();
    }

    private void levelOrder(TreeNode root, int depth,  List<List<Integer>> ans) {
        if (root == null)
            return;
        if (depth > ans.size() - 1){
            List<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        ans.get(depth).add(root.val);
        levelOrder(root.left, depth + 1, ans);
        levelOrder(root.right, depth + 1, ans);
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
