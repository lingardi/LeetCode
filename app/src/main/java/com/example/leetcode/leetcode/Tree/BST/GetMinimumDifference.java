package com.example.leetcode.leetcode.Tree.BST;

public class GetMinimumDifference {
    int res = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        //中序遍历，会先从右子树的左孩子开始，即最小差值最可能出现的位置
        if (pre != null){
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        inOrder(root.right);
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
