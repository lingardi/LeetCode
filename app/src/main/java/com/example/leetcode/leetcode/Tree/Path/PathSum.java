package com.example.leetcode.leetcode.Tree.Path;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 */
public class PathSum {
    /**
     * 在解决了以根节点开始的所有路径后，
     * 就要找以根节点的左孩子和右孩子开始的所有路径，三个节点构成了一个递归结构；
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        //由于起点不一定是根节点，需要计算左右子节点的路径数
        return paths(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int paths(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int ans = 0;
        if (root.val == sum)
            ans ++;
        ans += paths(root.left, sum - root.val);
        ans += paths(root.right, sum - root.val);
        return ans;
    }

    /**
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        int deep = depth(root);
        int[] path = new int[deep];

        count(root, sum, path, 0);
        return res;
    }
    int res = 0;

    public void count(TreeNode root, int sum, int[] path, int deep){
        if(root == null){
            return;
        }
        path[deep] = root.val;
        int t = 0;
        for(int i = deep; i >= 0; i--){
            t += path[i];
            if(t == sum){
                res += 1;
            }
        }
        count(root.left, sum, path, deep + 1);
        count(root.right, sum, path, deep + 1);
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
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
