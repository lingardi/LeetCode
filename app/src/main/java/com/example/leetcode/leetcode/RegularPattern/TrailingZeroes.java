package com.example.leetcode.leetcode.RegularPattern;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class TrailingZeroes {
    /**
     * f(n!) = g(n!) = g(5^K * K! * A) = K + g(K!) = K + f(K!)，其中K=n / 5（取整数）
     * 有多少个5的因子
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int zeros = 0;
        while(n > 0){
            n /= 5;
            zeros += n;
        }
        return zeros;
    }
}
