package com.example.leetcode.leetcode.Array;

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 */
public class MaximumProduct {
    /**
     * 最大的三个数，和最小的两个数。将最大的三数之积与最小两个数和最大数之积作比较
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        if (nums.length == 3)
            return nums[0] * nums[1] * nums[2];
        Arrays.sort(nums);
        int n = nums.length - 1;
        //只有一个正数或者两个正数的情况，最小的两个负数*正数
        int ans1 = nums[0] * nums[1] * nums[n];
        //全是正数或者全是负数
        int ans2 = nums[n] * nums[n-1] * nums[n-2];
        return Math.max(ans1, ans2);
    }
}
