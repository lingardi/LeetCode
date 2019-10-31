package com.example.leetcode.leetcode.Tree;

import java.util.Arrays;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *  
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxPos = maxPos(nums);

        if (maxPos == -1){
            return null;
        }
        //复制数组非常耗时
        int[] left = Arrays.copyOfRange(nums, 0, maxPos);
        int[] right = Arrays.copyOfRange(nums, maxPos+1, nums.length);

        TreeNode root = new TreeNode(nums[maxPos]);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);

        return root;
    }

    private int maxPos(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        int res = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[res]){
                res = i;
            }
        }
        return res;
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
