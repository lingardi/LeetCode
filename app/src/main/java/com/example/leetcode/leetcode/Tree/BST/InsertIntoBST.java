package com.example.leetcode.leetcode.Tree.BST;

import com.example.leetcode.leetcode.Tree.Judge.IsSameTree;

public class InsertIntoBST {
    public IsSameTree.TreeNode insertIntoBST(IsSameTree.TreeNode root, int val) {
//        if (root == null)
//            return new IsSameTree.TreeNode(val);

        if (root.val < val){
            return insertIntoBST(root.right, val);
        }
        if (root.val > val){
            return insertIntoBST(root.left, val);
        }
        return root;
    }
}
