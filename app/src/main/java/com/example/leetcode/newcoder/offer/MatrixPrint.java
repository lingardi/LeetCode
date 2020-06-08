package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;

public class MatrixPrint {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<String> ans = new ArrayList<>();
        printMatrix(ans, matrix);
        System.out.println(ans.toString());
    }

    public static ArrayList<String> printMatrix(ArrayList<String> ans, int[][] matrix) {
        StringBuilder builder = new StringBuilder();
        if (matrix.length == 0)
            return ans;
        int up = 0;
        int left = 0;
        int right = matrix[0].length;
        int down = matrix.length;
        while (left < right && up < down) {
            if (left < right && up < down) {
                for (int i = left; i < right; i++) {
                    ans.add(String.valueOf(matrix[up][i]));
                }
            }
            up++;

            if (left < right && up < down) {
                for (int i = up; i < down; i++) {
                    ans.add(String.valueOf(matrix[i][right - 1]));
                }

            }
            right--;

            if (left < right && up < down) {
                for (int i = right - 1; i >= left; i--) {
                    ans.add(String.valueOf(matrix[down - 1][i]));
                }

            }
            down--;

            if (left < right && up < down) {
                for (int i = down - 1; i >= up; i--) {
                    ans.add(String.valueOf(matrix[i][left]));
                }

            }
            left++;

        }
        return ans;
    }
}
