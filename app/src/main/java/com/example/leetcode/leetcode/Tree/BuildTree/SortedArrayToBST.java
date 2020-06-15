package com.example.leetcode.leetcode.Tree.BuildTree;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        int low = 0;
        int high = nums.length;
        return sortedArrayToBST(nums, low, high);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low == high)
            return null;
        int mid = (low + high) >>> 1;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, low, mid);
        root.right = sortedArrayToBST(nums, mid + 1, high);
        return root;
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
