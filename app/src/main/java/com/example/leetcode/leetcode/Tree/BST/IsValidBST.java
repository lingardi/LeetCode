package com.example.leetcode.leetcode.Tree.BST;

import java.util.Stack;

public class IsValidBST {
    /**
     * 栈，相当于先序遍历
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root){
        TreeNode cur;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        cur = root;

        while (true){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()){
                break;
            }
            cur = stack.pop();
            if (pre != null && pre.val >= cur.val)
                return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

    /**
     * 递归，更改上下限
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max){
        if (root == null){
            return true;
        }
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        return isValidBST2(root.left, min, root) && isValidBST2(root.right, root, max);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
