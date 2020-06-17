package com.example.leetcode.leetcode.DynamicPlanning;

public class WaysToStep {
    public int waysToStep(int n) {
        if(n < 2)
            return n;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i < n; i++){
            dp[i+1] = (dp[i] + dp[i-1] + dp[i-2]) % 1000000007;
        }
        return (int) dp[n];
    }
}
