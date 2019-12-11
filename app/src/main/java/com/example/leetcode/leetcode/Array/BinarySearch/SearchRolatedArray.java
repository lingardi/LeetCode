package com.example.leetcode.leetcode.Array.BinarySearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchRolatedArray {
    /**
     * 有条件的二分查找，需要判断是否为有序的部分
     * 数组旋转之后只存在两种情况：前半部分有序（nums[mid] > nums[end]）、后半部分有序(nums[mid] < nums[end])
     * 如1，2，3，4，5，6，7可分为 2 3 4 5 6 7 1 和6 7 1 2 3 4 5
     * 前半部分有序时，若num[start] <= target < nums[mid],就在前半部分找，否则后半部分；
     * 后半部分有序时，若num[mid] < target <= nums[end],就在后半部分找，否则前半部分
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end -start)/2;
            if (nums[mid] == target){
                return mid;
            }

            //后半部分有序
            if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else {
                if(nums[mid] > target && target >= nums[start]){
                    end = mid - 1;

                } else {
                    start = mid + 1;

                }


            }
        }
        return -1;


    }

    public static  void main(String[] args){
        search2(new int[]{5,1,2,3,4},1);
    }
}
