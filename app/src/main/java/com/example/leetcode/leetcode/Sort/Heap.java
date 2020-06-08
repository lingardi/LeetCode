package com.example.leetcode.leetcode.Sort;

import java.util.Arrays;

import static com.example.leetcode.CodeSample.Test.Test.a;

/**
 * 堆排
 * 时间复杂度：O(nlogn），不适合排序序列较少的情况
 * 定义：对直接排序的有效改进，完全二叉树，堆顶元素必须是最大或最小，大顶堆每个节点都大于或等于左右节点
 * 思想：顺序存储的二叉树，两个过程：建立堆、堆顶与最后一个元素交换位置
 */
public class Heap {
    public static void heapSort(int[] nums){
        if (nums.length == 0)
            return;
        for (int i = 0; i < nums.length - 1; i++){
            buildMaxHeap(nums, nums.length - 1 - i);
            swap(nums, 0, nums.length - 1 - i);
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void heapSort2(int nums[]){
        if (nums.length == 0)
            return;
        //构造大顶堆
        for(int i=nums.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums,i,nums.length);
        }
        //调整堆结构，交换堆顶元素和末尾元素
        for(int j=nums.length-1;j>0;j--){
            swap(nums,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(nums,0,j);//重新对堆进行调整
        }
    }

    /**
     * 调整过程，大顶堆已建立
     * @param nums
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && nums[k]<nums[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(nums[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                nums[i] = nums[k];
                i = k;
            }else{
                break;
            }
        }
        nums[i] = temp;//将temp,此时i已被k赋值，没有则不变
    }

    // 对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }

                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] data = new int[]{4, 6, 8, 5, 9, 7, 1};
        heapSort2(data);

        for (int i = 0; i <data.length; i++){
            System.out.println(data[i]);
        }
    }
}
