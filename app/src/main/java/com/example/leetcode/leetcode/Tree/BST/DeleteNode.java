package com.example.leetcode.leetcode.Tree.BST;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class DeleteNode {
    public static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;
        if (root.val == key){
                //1.无子节点，直接删； 2.单个子节点，以子节点代替；
                //3.双个子节点，左子树最大节点或者右子树最小节点代替,并删除代替节点
                if (root.right == null)
                    return root.left;
                if (root.left == null)
                    return root.right;
                //以右子树最小节点为例
                System.out.println(root.val);
                root.val = (int) getMinRight(root.right);
                root.right = deleteNode(root.right, getMinRight(root.right));
                System.out.println(root.val);
                return root;
        }else if (root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            root.left = deleteNode(root.left, key);
            return root;
        }
    }

    private static int getMinRight(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.val;
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
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.right = root6;
        deleteNode(root1, 4);

    }
}