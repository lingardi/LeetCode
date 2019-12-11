package com.example.leetcode.leetcode.Array.BinarySearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class FindMinRolatedArray {
    /**
     * 参照33的思路，前半部分有序时，若左端更小，则在前半部分找
     * 后半部分有序时，只可能在只有两个元素的时候，否则还是在前半部分找
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (nums[mid] < ans){
                ans = nums[mid];
            }

            if (nums[left] < nums[mid]){
                if (nums[left] < ans && nums[left] < nums[right]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                //在只剩两个元素时能够正确处理
                if (nums[right] < ans && nums[right] < nums[left]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return ans;
    }

    public static  void main(String[] args){
        findMin(new int[]{2,1});
    }
}
