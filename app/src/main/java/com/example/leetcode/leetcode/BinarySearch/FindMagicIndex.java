package com.example.leetcode.leetcode.BinarySearch;

/**
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 * 示例2:
 *
 *  输入：nums = [1, 1, 1]
 *  输出：1
 * 提示:
 *
 * nums长度在[1, 1000000]之间
 *
 */
public class FindMagicIndex {
    int res = -1;
    public int findMagicIndex(int[] nums) {
        if (nums.length == 0)
            return res;
        int low = 0;
        int high = nums.length - 1;
        search(nums, low, high);
        return res;
    }

    private void search(int[] nums, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) >> 1;
        //如果找到，往左边找更小的
        if (mid == nums[mid]){
            res = mid;
            search(nums, low, mid - 1);
        }else {
            search(nums, low, mid - 1);

            if (res == -1 || res > high){
                search(nums, mid + 1, high);
            }
        }
    }

}
