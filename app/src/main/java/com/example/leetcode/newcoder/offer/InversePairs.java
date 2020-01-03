package com.example.leetcode.newcoder.offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */
public class InversePairs {
    static int count = 0;
    /**
     * 归并排序思想
     * @param array
     * @return
     */
    public static int InversePairs(int[] array) {
        if (array.length <= 1)
            return 0;
        merge(array, 0, array.length -1);
        return count;
    }

    private static void merge(int[] array, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >>> 1;
        merge(array, start, mid);
        merge(array, mid + 1, end);
        mergeOne(array, start, mid, end);
    }

    private static void mergeOne(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int k = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end){
            //如果前面的元素小于后面的不能构成逆序对
            if (array[i] <= array[j]){
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
                //避免全部相加取余造成溢出
                count = (count + (mid-i+1))%1000000007;
            }
        }

        while(i<= mid)
            temp[k++] = array[i++];
        while(j<=end)
            temp[k++] = array[j++];
        for(int l=0; l<k; l++){
            array[start+l] = temp[l];
        }
    }

    public static void main(String[] args) {
        InversePairs(new int[]{1,2,3,4,5,6,7,0});
    }
}
