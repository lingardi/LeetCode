package com.example.leetcode.newcoder.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class Power {
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1d;
        double ans = 1d;
        boolean flag = exponent > 0;
        while (exponent != 0){
            ans = ans * base;
            exponent = Math.abs(exponent) - 1;
        }
        return flag ? ans : 1/ans;
    }
}
