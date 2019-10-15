package com.example.leetcode.leetcode.Tree.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        travel(root, "", paths);
        return paths;
    }

    private void travel(TreeNode root, String path, List<String> paths) {
        if (root == null)
            return;
        path += root.val;
        if (root.left == null && root.right == null){
            paths.add(path);
        }else {
            path += "->";
            travel(root.left, path, paths);
            travel(root.right, path, paths);
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return paths;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        nodes.add(root);
        queue.add(String.valueOf(root.val));
        while (!nodes.isEmpty()){
            TreeNode treeNode = nodes.poll();
            String ans = queue.poll();
            if (treeNode.left == null && treeNode.right == null){
                paths.add(ans);
            }
            if (treeNode.left != null){
                nodes.add(treeNode.left);
                queue.add(ans + "->" + treeNode.left.val);
            }
            if (treeNode.right != null){
                nodes.add(treeNode.right);
                queue.add(ans + "->" + treeNode.right.val);
            }
        }
        return paths;
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
