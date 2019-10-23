package com.example.leetcode.leetcode.Tree.BST;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Target = 9
 * 输出: True
 *  
 * 案例 2:
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Target = 28
 * 输出: False
 */
public class FindTarget {
    /**
     * 中序遍历增序保存所有节点值, 然后双指针遍历会更快
     * @param root
     * @param k
     * @return
     */
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        for (Integer i : set){
            if (set.contains(k - i) && i != k-i)
                return true;
        }
        return false;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        set.add(root.val);
        inorder(root.right);
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
