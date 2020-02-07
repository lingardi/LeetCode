package com.example.leetcode.newcoder.offer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if (A.length <= 1)
            return A;
        int[] res = new int[A.length];
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 1;
        right[A.length - 1] = 1;
        for (int i = 1; i< A.length; i++){
            left[i] = left[i - 1] * A[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--){
            right[i] = right[i + 1] * A[i + 1];
        }
        for (int i = 0; i < A.length; i++){
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
