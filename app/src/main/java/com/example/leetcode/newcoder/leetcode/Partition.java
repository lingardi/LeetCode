package com.example.leetcode.newcoder.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 */
public class Partition {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0)
            return res;
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++){
            for (int left = 0; left <= right; left++){
                if (s.charAt(left) ==s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1]))
                    dp[left][right] = true;
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;


    }

    private void backtracking(String s, int i, int len, boolean[][] dp, Deque<String> stack, List<List<String>> res) {

    }
}
