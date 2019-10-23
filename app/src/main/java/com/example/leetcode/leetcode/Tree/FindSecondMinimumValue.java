package com.example.leetcode.leetcode.Tree;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class FindSecondMinimumValue {
    static long one = Long.MAX_VALUE;
    static long two = Long.MAX_VALUE;

    /**
     * 初始值应为Long型最大值，避免two输出错误
     * @param root
     * @return
     */
    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return -1;
        inorder(root);
        return two == Long.MAX_VALUE ? -1 : (int) two;
    }

    private static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        //出现最小值，需将one值转移给two
        if (root.val < one){
            two = one;
            one = root.val;
            System.out.println("one="+one);

        }else if (root.val < two && root.val > one){
            two = root.val;
            System.out.println("two="+two);
        }
        inorder(root.right);
    }

    public static class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        findSecondMinimumValue(root);

    }
}
