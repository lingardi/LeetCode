package com.example.leetcode.newcoder.offer2;

public class FindMatrix {
    public boolean Find(int target, int [][] array) {
        if (array.length == 0)
            return false;
        int rows = array.length;
        int cols = array[0].length;
        int row = rows -1;
        int col = 0;
        while (row >= 0 && col < cols){
            if (array[row][col] < target){
                col++;
            }else if (array[row][col] > target){
                row--;
            }else {
                return true;
            }
        }
        return false;
    }
}
