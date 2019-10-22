package com.example.leetcode.leetcode.Tree.BST;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 
 * 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class SortedArrayToBST {
    /**
     * 二叉搜索树的中序遍历刚好可以输出一个升序数组。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        //传入end为length，使右边界能正确递归
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end)
            return null;
        int mid = (start + end) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        //右边界为length
        node.left = sortedArrayToBST(nums, start, mid);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }

    public  class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
