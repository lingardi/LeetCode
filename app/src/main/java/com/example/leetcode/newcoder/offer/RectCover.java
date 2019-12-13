package com.example.leetcode.newcoder.offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    /**
     * target = n时，第n级是横着覆盖，则剩下n-1级
     * 第n级是竖着覆盖，则剩下n-2级
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 2)
            return target;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i =3; i < target+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
