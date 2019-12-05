package com.example.leetcode.leetcode.Array;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {
    /**
     * output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积，即等于该位置左边元素的乘积 * 右边元素的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int[] leftTotal = new int[nums.length];
        int[] rightTotal = new int[nums.length];
        leftTotal[0] = 1;
        rightTotal[nums.length - 1] = 1;
        for (int i = 1; i < leftTotal.length; i++){
            leftTotal[i] = nums[i-1] * leftTotal[i-1];
        }
        //可以直接在算右边元素乘积时计算总输出，会更快
        for (int i = nums.length - 2; i >= 0; i--){
            rightTotal[i] = rightTotal[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++){
            out[i] = leftTotal[i] * rightTotal[i];
        }
        return out;
    }
}
