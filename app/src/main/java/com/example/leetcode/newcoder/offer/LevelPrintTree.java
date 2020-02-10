package com.example.leetcode.newcoder.offer;


import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class LevelPrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        print(pRoot, 0, ans);
        return ans;
    }

    private void print(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> ans) {
        if (pRoot == null)
            return;
        if (depth > ans.size() - 1){
            ArrayList<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        ans.get(depth).add(pRoot.val);
        print(pRoot.left, depth + 1, ans);
        print(pRoot.right, depth + 1, ans);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
