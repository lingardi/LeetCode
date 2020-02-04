package com.example.leetcode.newcoder.offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class TreeToList {
    static TreeNode pre = null;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;

        convertHelper(pRootOfTree);

        TreeNode res = pRootOfTree;
        while(res.left != null)
            res = res.left;
        return res;
    }

    private static void convertHelper(TreeNode cur) {
        if (cur == null)
            return;
        convertHelper(cur.left);

        if (pre != null){
            cur.left = pre;
            pre.right = cur;
        }
        pre = cur;

        convertHelper(cur.right);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(10);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(8);
        TreeNode root5 = new TreeNode(14);
        TreeNode root6 = new TreeNode(12);
        TreeNode root7 = new TreeNode(16);


        root1.left = root3;
        root1.right = root5;
        root3.left = root2;
        root3.right = root4;
        root5.left = root6;
        root5.right = root7;


        Convert(root1);
    }
}
