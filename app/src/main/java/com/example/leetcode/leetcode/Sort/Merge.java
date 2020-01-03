package com.example.leetcode.leetcode.Sort;

import java.util.Arrays;

/**
 * 归并排序：O(nlogn)
 */
public class Merge {
    public static void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(nums, low, mid);
            // 右边
            mergeSort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
            System.out.println(Arrays.toString(nums));
        }

    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end){
            if (nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid){
            temp[k++] = nums[i++];
        }

        while (j <= end){
            temp[k++] = nums[j++];
        }

        for (int l = 0; l < temp.length; l++){
            nums[start + l] = temp[l];
        }
    }
}
