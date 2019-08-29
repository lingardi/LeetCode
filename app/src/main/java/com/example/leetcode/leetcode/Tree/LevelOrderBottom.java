package com.example.leetcode.leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i =0 ;i < size; i++){
                TreeNode t = queue.poll();
                temp.add(t.val);
                if (t.left != null)
                    queue.offer(t.left);
                if (t.right != null)
                    queue.offer(t.right);
            }
            ans.add(0, temp);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        travel(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }

    private void travel(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (depth > ans.size() - 1){
            List<Integer> list = new ArrayList<>();
            ans.add(list);  //不能直接添加至list首项，需根据添加顺序添加相应元素
        }
        ans.get(depth).add(root.val);
        travel(root.left, depth+1, ans);
        travel(root.right, depth+1, ans);
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
