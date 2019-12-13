package com.example.leetcode.newcoder.offer;

import com.example.leetcode.leetcode.Tree.SumNumbers;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (in.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++){
            if (in[i] == pre[0]){
                //copyOfRange方法length为 to - from，所以取pre的i+1，in的i
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }

    public static class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
