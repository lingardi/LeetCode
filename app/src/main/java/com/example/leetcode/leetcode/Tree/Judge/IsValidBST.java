package com.example.leetcode.leetcode.Tree.Judge;

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

    public boolean isValidBST(TreeNode root){
        if (root == null)
            return true;
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return isValidBST2(root, min, max);
    }
    /**
     * 递归，更改上下限
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST2(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max)
            return false;
        return isValidBST2(root.left, min, root.val) && isValidBST2(root.right, root.val, max);
    }


    TreeNode pre = null;
    /**
     * 最快的递归方式
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST3(root.left))
            return false;
        if (pre != null && pre.val >= root.val)
            return false;
        pre = root;
        return isValidBST3(root.right);
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
