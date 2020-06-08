package com.example.leetcode.newcoder.offer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1)
            return 0;
        boolean[] visited = new boolean[rows * cols];
        for (int i =0; i < visited.length; i++){
            visited[i] = false;
        }
        return movingCountHelper(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountHelper(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols
            && !visited[row * cols + col] && (getDigits(row) + getDigits(col)) <= threshold){
            count ++;
            visited[row * cols + col] = true;
            count += movingCountHelper(threshold, rows, cols, row - 1, col, visited)
                    + movingCountHelper(threshold, rows, cols, row + 1, col, visited)
                    + movingCountHelper(threshold, rows, cols, row , col - 1, visited)
                    + movingCountHelper(threshold, rows, cols, row, col + 1, visited);
        }

        return count;
    }

    private int getDigits(int num) {
        if (num == 0)
            return 0;
        int res = 0;
        while (num > 0){
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
