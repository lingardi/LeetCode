package com.example.leetcode.leetcode.Array.BinarySearch;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int mid = (start + end)/2;
        if (target > nums[end]){
            return end + 1;
        }
        while (start <= end){
            if (target == nums[mid]){
                return mid;
            }else if (target < nums[mid]){
                end = mid - 1;
                mid = (start + end)/2;
            }else {
                start = mid + 1;
                mid = (start + end)/2;
            }
        }
        return start;
    }

    public static int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        if (target <= nums[0])
            return 0;
        if (target > nums[end])
            return end + 1;

        while (start < end){
            int mid = (start + end + 1) >>> 1;
            if (target < nums[mid]){
                end = mid - 1;
            }else {
                start = mid;
            }
        }
        if (nums[start] == target)
            return start;
        return start + 1;
    }

    public static void main(String[] args){
        searchInsert2(new int[]{1,3,5,6},2);
    }
}
