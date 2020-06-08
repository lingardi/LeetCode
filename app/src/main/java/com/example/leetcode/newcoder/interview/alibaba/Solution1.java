package com.example.leetcode.newcoder.interview.alibaba;

import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][3];
        long[][] dp = new long[n][3];

        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < n; ++j){
                matrix[j][i] = scanner.nextInt();
            }
        }

        for (int i = 1; i < n; ++i){
            for (int j = 0; j < 3; ++j){
                dp[i][j] = Long.MAX_VALUE;
                for (int k = 0; k < 3; ++k){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(matrix[i][j] - matrix[i-1][k]));
                }
            }
        }
        long ans = Math.min(Math.min(dp[n-1][2], dp[n-1][1]), dp[n-1][0]);
        System.out.print(ans);
    }
}
