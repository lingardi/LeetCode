package com.example.leetcode.leetcode.Array;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0)
            return;
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++){
            if (rows[i] == 1){
                for (int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++){
            if (cols[i] == 1){
                for (int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
