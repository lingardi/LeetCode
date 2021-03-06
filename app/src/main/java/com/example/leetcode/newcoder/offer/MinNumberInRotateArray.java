package com.example.leetcode.newcoder.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (array[mid] < ans){
                ans = array[mid];
            }
            //总有一侧是顺序的
            //左侧有序，二分查找
            if (array[left] < array[mid]){
                if (array[left] < ans && array[left] < array[right]){
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }else {
                //右侧有序
                if (array[right] < ans && array[right] < array[left]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return ans;
    }
}
