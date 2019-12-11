package com.example.leetcode.leetcode.Array.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *  
 * 示例 2:
 *
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 *  
 * 说明:
 *
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *  
 * 更新(2017/9/19):
 * 这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。请重新加载代码定义以获取最新更改。
 */
public class KClosestElements {
    /**
     * 双指针，O(n)，三种情况
     * x < arr[0], 取前k个
     * x > arr[n-1]. 取后k个
     * 否则双指针一个一个排除
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int left = 0;
//        int right = arr.length - 1;
        List<Integer> ans = new ArrayList<>();
//        while (left < right){
//            int mid = (left + right) >>> 1;
//            if (arr[mid] < x){
//                left = mid + 1;
//            }else {
//                right = mid;
//            }
//        }
        if (arr.length == 1){
            ans.add(arr[0]);
            return ans;
        }
        if (arr[0] > x){
            addInteger(ans, arr, 0, k);
        }else if (arr[arr.length - 1] < x){
            addInteger(ans, arr, arr.length - k -1, arr.length - 1);
        }else {
            int start = 0;
            int end = arr.length - 1;
            while (start + k < end){
                if (x - arr[start] <= arr[end] - x){
                    end --;
                }else {
                    start++;
                }
            }
            if (x- arr[start] <= arr[end] -x){
                addInteger(ans, arr, start, end);
            }else {
                addInteger(ans, arr, start + 1, end + 1);
            }
        }

        return ans;
    }

    private static void addInteger(List<Integer> ans, int[] arr, int start, int end) {
        for (int i =start; i < end; i++){
            ans.add(arr[i]);
        }
    }

    /**
     * 二分法，找到最优区间的左边界，范围为[0, size - k], 使x能处于中位数的位置
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (x - arr [mid] > arr[mid + k] - x){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        for (int i = left; i < left + k; i++){
            list.add(arr [i]);
        }
        return list;
    }


    public static void main(String[] args){
        findClosestElements(new int[]{1,2,3,4,5},4,3);
    }
}
