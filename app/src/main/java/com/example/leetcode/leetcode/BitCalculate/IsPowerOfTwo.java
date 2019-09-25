package com.example.leetcode.leetcode.BitCalculate;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        while (n > 1){
            int m = n % 2;
            if (m == 1)
                return false;
            n = n / 2;
        }
        return true;
    }

    /**
     * 位运算，2的n次幂（如8为1000），2的n次幂减1为（如7为0111），相与为0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
