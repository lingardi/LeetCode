package com.example.leetcode.newcoder.offer2;

import com.example.leetcode.leetcode.Tree.SumNumbers;

public class ConstructTree {
    public TreeNode construct(int[] pre, int[] in){
        if (pre == null || in == null || pre.length != in.length)
            return null;
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode construct(int[] pre, int pLeft, int pRight, int[] in, int iLeft, int iRight) {
        if (pLeft > pRight)
            return null;
        TreeNode root = new TreeNode(pre[pLeft]);
        int index = iLeft;
        while (index <= iRight && in[index] != root.val){
            index++;
        }

        root.left = construct(pre, pLeft + 1, index - iLeft + pLeft, in, iLeft, index);
        root.right = construct(pre, index - iLeft + pLeft + 1,  pRight, in, index + 1, iRight);
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
