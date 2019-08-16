package com.example.leetcode.leetcode.Array;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 */
public class MergeTwoArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            nums1 = nums1;
        if (m == 0){
            for (int i =0; i < nums2.length; i++){
                nums1[i] = nums2[i];
            }
        }
        int[] nums = new int[m + n];
        for (int i = 0; i < m; i++){
            nums[i] = nums1[i];
        }
        int j =0;
        for (int i= 0; i < m+n; i++){
            for (; j < nums2.length; j++){
                if (nums[i] <= nums2[j] && nums[i] != 0){
                    nums1[i] = nums[i];
                    break;
                }else {
                    nums1[i + j] = nums2[j];
                }
            }
            if (j == nums2.length && i < m){
                for (int k =0; k < m - i; k++){
                    nums1[i+ j + k] = nums[i + k];
                }
            }
        }
    }
}
