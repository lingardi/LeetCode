package com.example.leetcode.newcoder.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if (target <= 2)
            return target;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        int ans = dp[1];
        for (int i = 2; i < target + 1; i++){
            dp[i] = dp[0] + ans;
            ans += dp[i];
        }
        return dp[target];
    }
}
