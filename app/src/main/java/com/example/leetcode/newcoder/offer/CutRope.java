package com.example.leetcode.newcoder.offer;

import com.example.leetcode.CodeSample.Retrofit.Main;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 * 示例1
 * 输入
 * 8
 * 输出
 * 18
 */
public class CutRope {
    public int cutRope(int target) {
        return cutCope(target, 0);
    }

    /**
     * 递归，定义maxValue(n)为把绳子剪成n段后的各段乘积最大值，第一刀时有n-1中选择，
     * 即第一段绳子长度可为1、2、3...n-1，maxValue = maxValue(i)*maxValue(n-i)
     * @param target
     * @param max
     * @return
     */
    private int cutCope(int target, int max) {
        int maxValue = max;
        for (int i = 1; i < target; i++){
            maxValue = Math.max(maxValue, i*cutCope(target - i, target - i));
        }
        return maxValue;
    }

    /**
     * f[i]表示长度为i的绳子的乘积最大值。
     * f[i] = Max{f[j]*f[i-j]} 0<j<i
     * @param target
     * @return
     */
    public int cutRope2(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            if (i != target) { // 当i!=target时，长度为i的段也可以不分割！
                dp[i] = i;
            }
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[target];
    }

}
