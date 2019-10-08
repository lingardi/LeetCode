package com.example.leetcode.leetcode.Sort;

public class Quick {
    /**
     * 基本实现思路：
     *
     * 1.从数列中挑出一个元素，称为 "基准"
     * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，
     * 所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分割之后，该基准是它的最后位置。这个称为分割操作。
     * 3.递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param nums
     * @param low
     * @param high
     */
    public void quickSort(int nums[], int low, int high){
        int left, right, base;
        if (low > high)
            return;
        left = low;
        right = high;
        base = nums[low];

        while (left < right){
            while (base <= nums[right] && left < right){
                right --;
            }
            while (base >= nums[left] && left < right){
                left ++;
            }

            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[low] = nums[left];
        nums[left] = base;
        //递归调用左半数组
        quickSort(nums, low, right -1 );
        //递归调用右半数组
        quickSort(nums, right+1, high);
    }
}
