package com.example.leetcode.leetcode.RegularPattern;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        int count = 0;
        // 元素设置标记
        boolean[] nums = new boolean[n];

        for (int i = 2; i * i < n; i++){
            // 用 ! 判断，就不用循环遍历设置数组元素都为ture
            if (!nums[i]) {

                for (int j = i * i; j < n; j += i) {

                    // 判断是为了去重(i=2,j=12; i=3,j=12),提高效率
                    if (nums[j])
                        continue;

                    // 这里递增，可以直接得到非质数的数量
                    count++;

                    // 非质数标记清除
                    nums[j] = true;
                }
            }
        }
        // 排除 0 和 1 ，所以要-2
        return n - count - 2;
    }
}
