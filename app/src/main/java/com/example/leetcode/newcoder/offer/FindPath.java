package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        helper(ans, list, root, target);
        return ans;
    }

    private void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, TreeNode root, int target) {
        if (root == null)
            return;
        target -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null){
            if (target == 0)
                ans.add(new ArrayList<>(list));
        }
        helper(ans, list, root.left, target);
        helper(ans, list, root.right, target);

        //回溯，需要减去当前节点
        list.remove(list.size() -1 );
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
