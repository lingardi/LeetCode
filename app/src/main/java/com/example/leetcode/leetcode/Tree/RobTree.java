package com.example.leetcode.leetcode.Tree;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，
 * 房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class RobTree {
    /**
     * dp[i] = Math.max(dp[i - 2] + nums[cur], dp[i - 1]);
     * 当树为三层满二叉树时，最大的取值方式只有四种，包含根节点 + 三层4个的、只含二层2个节点、包含二层1个节点 + 三层2个节点
     *
     * dp[root] = Max(dp[l]+dp[r], root.val+dp[ll]+dp[lr]+dp[rr]+dp[rl], dp[l]+dp[rl]+dp[rr], dp[r]+dp[lr]+dp[rl]);
     * 在dp[l]和dp[r]的计算中实际已经包含了dp[ll]、dp[lr]、dp[rr]、dp[rl]的取舍情况
     *
     * 可以简化为前两种情况。状态转移方程简化为：
     * dp[root] = Max(dp[l]+dp[r], root.val+dp[ll]+dp[lr]+dp[rr]+dp[rl]);
     * @param root
     * @return
     */
    public static int rob(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root).val;
    }

    private static TreeNode helper(TreeNode root) {
        if (root == null){
            TreeNode node = new TreeNode(0);
            return helper(node);
        }
        if (root.left == null && root.right == null){
            TreeNode left = new TreeNode(0);
            TreeNode right = new TreeNode(0);
            root.left = left;
            root.right = right;
            return root;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        root.val = Math.max(root.val + root.left.left.val +
                root.left.right.val + root.right.left.val + root.right.right.val, root.left.val + root.right.val);
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

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(1);

        root1.left = root2;
        root1.right = root3;
        root2.right = root4;
        root3.right = root5;
        rob(root1);
    }
}
