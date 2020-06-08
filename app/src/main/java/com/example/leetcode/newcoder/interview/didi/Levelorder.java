package com.example.leetcode.newcoder.interview.didi;

import com.example.leetcode.newcoder.offer.KthNode;
import com.example.leetcode.newcoder.offer.Serialize;

import java.util.ArrayList;
import java.util.List;

public class Levelorder {
    public ArrayList<ArrayList<Integer>> levelorder(TreeNode root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        helper(root, 0, ans);
        return ans;
    }

    private void helper(TreeNode root, int depth, ArrayList<ArrayList<Integer>> ans) {
        if (root == null)
            return;
        if (depth > ans.size() - 1){
            ArrayList<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        ans.get(depth).add(root.val);
        helper(root.left, depth+1, ans);
        helper(root.right, depth+1, ans);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
