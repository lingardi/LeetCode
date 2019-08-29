package com.example.leetcode.leetcode.Tree.BST;

import com.example.leetcode.leetcode.Tree.IsSameTree;

public class DeleteNode {
    public IsSameTree.TreeNode deleteNode(IsSameTree.TreeNode root, int key) {
        if (root.val == key){
            //1.无子节点，直接删； 2.单个子节点，以子节点代替；
            //3.双个子节点，左子树最大节点或者右子树最小节点代替,并删除代替节点
            if (root.right == null)
                return root.left;
            if (root.left == null)
                return root.right;
            //以右子树最小节点为例
            root.val = (int) getMinRight(root.right);
            root.right = deleteNode(root.right, getMinRight(root.right));
        }
        if (root.val < key)
            return deleteNode(root.right, key);
        if (root.val > key)
            return deleteNode(root.left, key);
        return root;
    }

    private int getMinRight(IsSameTree.TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.val;
    }
}