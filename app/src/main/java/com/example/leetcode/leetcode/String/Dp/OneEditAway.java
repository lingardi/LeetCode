package com.example.leetcode.leetcode.String.Dp;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 */
public class OneEditAway {
    /**
     * 动态规划，dp[0][0]为0，dp[i+1][j+1]代表A(i) -> B(i)的最小编辑距离
     * 若first(i) = second(j)，则dp[i+1][j+1] = dp[i][j]
     * 否则A[i]替换为B[j]时，dp[i+1][j+1] = dp[i][j] + 1
     * 当A[i]新增一个字符B[j]时，dp[i+1][j+1] = dp[i+1][j] + 1
     * 当A[i]删减一个字符B[j]时，dp[i+1][j+1] = dp[i][j+1] + 1
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        if (first.length() == 0 && second.length() == 0)
            return true;
        if (Math.abs(first.length() - second.length()) > 1)
            return false;
        int[][] dp = new int[first.length()+1][second.length()+1];
        dp[0][0] = 0;
        for (int i = 1; i <= first.length(); i++){
            dp[i][0] = i;
        }
        for (int j = 1; j <= second.length(); j++){
            dp[0][j] = j;
        }
        for (int i = 0; i < first.length(); i++){
            for (int j =0; j < second.length(); j++){
                if (first.charAt(i) == second.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1]+1, dp[i+1][j]+1), dp[i][j]+1);
                }
            }
        }
        return dp[first.length()][second.length()] < 2;
    }
}
