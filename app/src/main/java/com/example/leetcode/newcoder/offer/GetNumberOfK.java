package com.example.leetcode.newcoder.offer;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    /**
     * 二分查找，分别找到第一个k和最后一个k
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK(int[] array, int k) {
        if (array.length == 0)
            return 0;
        int high = search(array, k);
        int low = search2(array, k);
        return array[high] == array[low] && (array[low] == k || array[high] == k) ? high - low + 1 : 0;
    }

    private static int search2(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;

        while (start < end){
            int mid = (start + end + 1) >>> 1;
            if (k < array[mid]){
                end = mid - 1;
            }else if (mid > 0 && array[mid - 1] == k){
                end = mid - 1;
            }else {
                start = mid;
            }
        }
        return start;
    }

    private static int search(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;

        while (start < end){
            int mid = (start + end) >>> 1;
            if (k > array[mid]){
                start = mid + 1;
            }else if (mid < array.length - 1 && array[mid + 1] == k){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args){
        GetNumberOfK(new int[]{1,3,3,3,3,4,5},0);
    }

}
