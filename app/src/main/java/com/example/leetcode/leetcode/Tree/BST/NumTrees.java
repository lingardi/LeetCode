package com.example.leetcode.leetcode.Tree.BST;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class NumTrees {
    /**
     * 动态规划找规律
     * 设F(i, n)为n个数中以i为根节点可以得到的BST个数
     * 设G(n) 为n个数可以得到的BST个数
     *
     * 则有G(n) = F(1, n) + F(2, n) + ...+ F(n, n)
     * 对于F(i, n)以i为根节点，则可以通过左右子树排列组合个数推算，有F(i, n) = G(i - 1)*G(n - i)
     *
     * 所以G(n) = G(0)*G(n - 1) + G(1)*G(n - 2) + ...+ G(n - 1)*G(0), i = 1,2...n
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //填充dp数组
        for (int i = 2; i <= n; i++){
            //dp数组每一项都需要n项叠加, 此处n == i
            for (int j =1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
