package com.example.leetcode.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class SumNumbers {
    static List<String> pathSum = new ArrayList<>();
     String res = "";
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        if (root == null)
            return ans;
//        dfs(root, res);
        System.out.println(pathSum.toString());
        for (String s : pathSum){
            ans += Integer.valueOf(s);
            System.out.println(ans);
        }
        return ans;
    }

    int sum = 0;
    public int sumNumbers2(TreeNode root) {
        int num = 0;
        if (root == null)
            return num;
        dfs(root, num);
        System.out.println(pathSum.toString());

        return sum;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null)
            return;
//        res += root.val;
        num = num* 10 + root.val;
        if (root.left == null && root.right == null){
//            pathSum.add(res);
            sum += num;
        }
        dfs(root.left, num);
        dfs(root.right, num);
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
