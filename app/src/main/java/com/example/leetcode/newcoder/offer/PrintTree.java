package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        print(pRoot, 0, ans);
        for (int i = 0; i < ans.size(); i++){
            if (i % 2 == 1) {
                Collections.reverse(ans.get(i));
            }
        }
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

    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if (flag){
                    list.add(0, temp.val);
                }else {
                    list.add(temp.val);
                }
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            flag = !flag;
            ans.add(list);
        }
        return ans;
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
