package com.example.leetcode.newcoder.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class Power {
    public double Power2(double base, int exponent) {
        if (exponent == 0)
            return 1.0;
        double ans = 1.0;
        boolean flag = exponent > 0;
        while (exponent != 0){
            ans = ans * base;
            exponent = Math.abs(exponent) - 1;
        }
        return flag ? ans : 1/ans;
    }

    /**
     * 递归，快速幂，分为奇偶数
     * 奇数 = half * half * base
     * 偶数 = half * half
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1d;
        long e = exponent;
        if (exponent < 0){
            base = 1/base;
            e = -e;
        }
        return power(base, e);
    }

    private double power(double base, long e) {
        if (e == 0){
            return 1d;
        }
        double half = power(base, e/2);
        if (e % 2 == 1){
            return half * half * base;
        }else {
            return half * half;
        }
    }

    public double Power1(double base, int exponent) {
        if (exponent == 0)
            return 1d;
        double ans = 1d;;
        long e = exponent;
        if (e < 0){
            base = 1/base;
            e = -e;
        }
        double cur = base;
        while (e > 0){
            if (e % 2 == 1){
                ans = ans * cur;
            }
            cur = cur * cur;
            e = e/2;
        }
        return ans;
    }
}
