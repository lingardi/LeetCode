package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;
        int up = 0;
        int left = 0;
        int right = matrix[0].length ;
        int down = matrix.length ;
        while (left < right && up < down) {
            if (left < right && up < down) {
                for (int i = left; i < right; i++) {
                    ans.add(matrix[up][i]);
                }

            }
            up++;

            if (left < right && up < down) {
                for (int i = up; i < down; i++) {
                    ans.add(matrix[i][right - 1]);
                }

            }
            right--;

            if (left < right && up < down) {
                for (int i = right - 1; i >= left; i--) {
                    ans.add(matrix[down - 1][i]);
                }

            }
            down--;

            if (left < right && up < down) {
                for (int i = down - 1; i >= up; i--) {
                    ans.add(matrix[i][left]);
                }

            }
            left++;

        }
        return ans;
    }

    public ArrayList<Integer> printMatrix2(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int endcolumn = matrix[0].length;
        int endrow = matrix.length;
        int startcolumn = 0;
        int startrow = 0;
        int i=0;
        int j=0;
        while(startrow<endrow&&startcolumn<endcolumn){
            if(startrow<endrow&&startcolumn<endcolumn)
                for(i=startcolumn;i<endcolumn;i++){
                    result.add(matrix[startrow][i]);
                }
            startrow++;
            if(startrow<endrow&&startcolumn<endcolumn)
                for(j=startrow;j<endrow;j++){
                    result.add(matrix[j][endcolumn-1]);
                }
            endcolumn--;
            if(startrow<endrow&&startcolumn<endcolumn)
                for(i=endcolumn-1;i>=startcolumn;i--){
                    result.add(matrix[endrow-1][i]);
                }
            endrow--;
            if(startrow<endrow&&startcolumn<endcolumn)
                for(j=endrow-1;j>=startrow;j--){
                    result.add(matrix[j][startcolumn]);
                }
            startcolumn++;
        }
        return result;
    }

    public static void main(String[] args) {
        printMatrix(new int[][]{{1}});
    }
}

