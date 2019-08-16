package com.example.leetcode.leetcode.DynamicPlanning;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 *
 * 到达第 i 阶的方法总数就是到第 (i-1)阶和第 (i-2)(i−2) 阶的方法数之和。
 *
 * 令 dp[i] 表示能到达第 i 阶的方法总数：
 *
 * dp[i]=dp[i-1]+dp[i-2]
 *
 * 时间复杂度：O(n)，单循环到 n 。
 *
 * 空间复杂度：O(n)，dp 数组用了 n 的空间。
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i =3; i < n + 1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
