package com.example.leetcode.leetcode.Array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return;
        int temp;
        int pre;
        for (int i =0; i < k; i++){
            pre = nums[nums.length -1];
            for (int j = 0; j < nums.length; j++){
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }


    /**
     * 当K > 数组长度时，取余
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return;
        k %= nums.length;
        reverse(nums, 0 , nums.length - 1);
        reverse(nums, 0, k -1);
        reverse(nums,k, nums.length -1);
    }

    /**
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start ++] = nums[end];
            nums[end --] = temp;
        }
    }
}
