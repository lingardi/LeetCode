package com.example.leetcode.leetcode.BinarySearch;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        long left = 1;
        long right = x/2;
        while (left < right){
            long mid = (left + right +1) >>> 1;
            long square = mid * mid;
            if (square > x){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int) left;
    }
}
