package com.example.leetcode.newcoder.offer;

/**
 *
 */
public class HasPathMetrics {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows*cols || str == null || str.length < 1)
            return false;
        boolean[] visited = new boolean[rows * cols];
        //访问数组
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        //记录结果的数组
        int[] pathLength = {0};
        //以每一个点为起点开始搜索
        for (int i = 0; i < rows; i++){
            for (int j =0; j < cols; j++){
                if (hasPath(matrix, rows, cols, str, visited, i, j, pathLength)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int row, int col, int[] pathLength) {
        if (pathLength[0] == str.length)
            return true;
        boolean isPath = false;

        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row* cols + col] == str[pathLength[0]]
                && !visited[row* cols + col]){
            visited[row * cols + col] = true;
            pathLength[0]++;

            //按左上右下进行回溯
            isPath = hasPath(matrix,rows,cols,str,visited,row - 1, col,pathLength)
                    || hasPath(matrix,rows,cols,str,visited,row + 1, col,pathLength)
                    || hasPath(matrix,rows,cols,str,visited,row , col - 1,pathLength)
                    || hasPath(matrix,rows,cols,str,visited,row, col+1,pathLength);
            if (!isPath){
                pathLength[0] --;
                visited[row * cols + col] = false;
            }

        }
        return isPath;
    }
}
