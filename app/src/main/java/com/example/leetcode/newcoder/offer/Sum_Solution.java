package com.example.leetcode.newcoder.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {
    public static int Sum_Solution(int n) {
        int sum=n;
        boolean flag = (sum>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        Sum_Solution(5);
    }

}
