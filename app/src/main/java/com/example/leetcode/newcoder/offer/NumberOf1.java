package com.example.leetcode.newcoder.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
       if (n == 0)
           return 0;
       return Integer.bitCount(n);
    }

    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
     * 那么一个整数的二进制有多少个1
     * @param n
     * @return
     */
    public int NumberOf12(int n) {
        if (n == 0)
            return 0;
        int ans = 0;

        while (n != 0){
            ans ++;
            n = n & (n-1);
        }
        return ans;
    }
}
