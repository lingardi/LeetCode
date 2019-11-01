package com.example.leetcode.leetcode.Tree.Backorder;

import android.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        Queue<Map.Entry<TreeNode, Integer>> p = new LinkedList<>();
        Map.Entry<TreeNode, Integer> entry = new HashMap.SimpleEntry<TreeNode, Integer>(root, 1);
        p.add(entry);
        while (! p.isEmpty()){
            Map.Entry<TreeNode, Integer> p1 = p.poll();
            root = p1.getKey();
            int cur = p1.getValue();
            if (root != null){
                depth = Math.max(depth, cur);
                ((LinkedList<Map.Entry<TreeNode, Integer>>) p).add(new HashMap.SimpleEntry<TreeNode, Integer>(root.left, depth+1));
                ((LinkedList<Map.Entry<TreeNode, Integer>>) p).add(new HashMap.SimpleEntry<TreeNode, Integer>(root.right, depth+1));
            }
        }
        return depth;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int leftH = maxDepth2(root.left);
        int rightH = maxDepth2(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    public  class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
