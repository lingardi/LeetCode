package com.example.leetcode.leetcode.Array;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {
    /**
     * 先计数，再填数组
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int zero = 0;
        int one = 0;
        for (int i =0; i < nums.length; i++){
            if (nums[i] == 0){
                zero ++;
            }else if (nums[i] == 1){
                one ++;
            }
        }
        for (int i =0; i < nums.length; i++){
            if (i < zero){
                nums[i] = 0;
            }else if (i < zero + one){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
    }

    /**
     * 快排思想，i、j两个指针，j指针移动过程中遇到0，则与i交换
     * 当0全部移至数组左端，则j遇到1交换，遍历两次
     * @param nums
     */
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int i = 0;
        for (int j =0; j < nums.length; j++){
            if (nums[j] == 0){
                int temp = nums[i];
                nums[i] = 0;
                nums[j] = temp;
                i++;
            }
        }

        for (int j =i; j < nums.length; j++){
            if (nums[j] == 1){
                int temp = nums[i];
                nums[i] = 1;
                nums[j] = temp;
                i++;
            }
        }
    }
}
