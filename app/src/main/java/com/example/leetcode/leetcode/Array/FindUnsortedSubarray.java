package com.example.leetcode.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 */
public class FindUnsortedSubarray {
    /**
     * 利用堆栈找到含相同数值情况下的最小左边界和最大有边界
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1)
            return 0;
        int right = 0;
        int left = nums.length - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i =0; i < nums.length; i++){
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()])
                left = Math.min(left, stack.pop());
            stack.push(i);
        }

        stack.clear();
        for (int i = nums.length -1; i > 0; i--){
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()])
                right = Math.max(right, stack.pop());
            stack.push(i);
        }

        return right - left <= 0 ? 0 : right -left +1;
    }

    /**
     * 排序，对比最小差异左边界和最大差异右边界
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        if (nums.length == 1)
            return 0;
        int nums1[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums1);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums1[i] != nums[i]){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start == 0 ? 0 : (end - start+ 1);
    }
}
