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
    /**
     * 二分法
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
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

    /**
     * 牛顿迭代法
     * 递推方程：X[i]=X[i-1]/2 + t/(2 * X[i-1])
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        double t=(double)x;//(double)可以省
        double x0=x;
        x0=x0/2+t/(2*x0);
        while(Math.abs(x0*x0-t)>0.00001)
            x0=x0/2+t/(2*x0);
        return (int)x0;//double 转int类型必须使用强制类型转化
    }

    public static void main(String[] args){
        mySqrt(5);
    }
}
