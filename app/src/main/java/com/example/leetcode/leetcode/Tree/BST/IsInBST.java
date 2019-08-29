package com.example.leetcode.leetcode.Tree.BST;

import com.example.leetcode.leetcode.Tree.IsSameTree;

/**
 * BST中查找一个数是否存在
 */
public class IsInBST {
    public boolean isInBST(IsSameTree.TreeNode root, int target){
        if (root == null)
            return false;
        if (root.val == target){
            return true;
        }
        if (root.val < target)
            return isInBST(root.right, target);
        return isInBST(root.left, target);
    }
}
