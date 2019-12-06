package com.example.leetcode.leetcode.BinarySearch;

public class BinarySearch {
    /**
     * 分支逻辑不能排除左边界，选右中位数，右边界收缩，避免只剩两个元素时死循环
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            //加1得到右中位数，选中位数的依据是避免死循环
            int mid = (left + right + 1) >>> 1;
            //分支数减为2，提高执行效率，先写排除中位数的分支逻辑
            if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        //检查最后的输出是否满足目标
        if (nums[left] == target)
            return left;
        return -1;
    }

    /**
     * 分支逻辑不能排除右边界，选左中位数，左边界收缩
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //循环结束时必有left = right
        while (left < right){
            //得到左中位数，选中位数的依据是避免死循环
            int mid = (left + right) >>> 1;
            //分支数减为2，提高执行效率，先写排除中位数的分支逻辑
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        //检查最后的输出是否满足目标
        if (nums[left] == target)
            return left;
        return -1;
    }
}
