package com.example.leetcode.leetcode.DynamicPlanning;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *
 *  输入：A = 1, B = 10
 *  输出：10
 * 示例2:
 *
 *  输入：A = 3, B = 4
 *  输出：12
 * 提示:
 *
 * 保证乘法范围不会溢出
 *
 */
public class Multiply {
    public int multiply(int A, int B) {
        if (A == 0 || B == 0)
            return 0;
        if (B == 1)
            return A;
        return helper(A, B);
    }

    private int helper(int a, int b) {
        if (b == 1)
            return a;
        int half = helper(a, b /2);
        return b%2 == 1 ? half*2 + a : half*2;
    }
}
