package com.example.leetcode.leetcode.Array;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProductSub {
    /**
     * 动态规划思想
     * 当前位置的最大值为Math.max(nums[i] * max, nums[i])，由于数组中存在负数，
     * 当num[i]为负数时，最大值会变成最小值，最小值会变成最大值，所以需要同时维护max、min
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int ans = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            //取最值是避免乘完当前值（比如为负数），得到更小的max，所以不能采用下面的写法
            max = Math.max(nums[i] * max, nums[i]);
            min = Math.min(nums[i] * min, nums[i]);
//            max = nums[i] * max;
//            min = nums[i] * min;

            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args){
        maxProduct(new int[]{0,2});
    }
}
