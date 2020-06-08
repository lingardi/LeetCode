package com.example.leetcode.newcoder.offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInArrays {
    /**
     * 从右上角开始找，O（m+n）
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {
        if (array.length == 0)
            return false;
        int n = array[0].length - 1;
        int m = 0;
        while (m < array.length &&  n >= 0){
            if (array[m][n] < target){
                m++;
            }else if (array[m][n] > target){
                n--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Find(7,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}});
    }
}
