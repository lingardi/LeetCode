package com.example.leetcode.leetcode.DynamicPlanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 */
public class PathWithObstacles {
    static int rows;
    static int cols;
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> ans = new ArrayList<>();
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
        if (rows == 0)
            return ans;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols -1] == 1)
            return ans;
        boolean[] visited = new boolean[rows*cols];
        dfs(obstacleGrid, ans, visited, 0, 0);
        return ans;
    }

    private static boolean dfs(int[][] obstacleGrid, List<List<Integer>> ans, boolean[] visited, int row, int col) {
        if (row >= rows || col >= cols || visited[row * cols + col] || obstacleGrid[row][col] == 1)
            return false;
        ans.add(Arrays.asList(row, col));
        visited[row * cols + col] = true;
        if (row == rows - 1 && col == cols - 1)
            return true;
        if (dfs(obstacleGrid, ans, visited, row+1, col) || dfs(obstacleGrid, ans, visited, row, col+1))
            return true;
        ans.remove(ans.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0,0,0},{1,1,0},{0,0,0}};
        pathWithObstacles(input);
    }
}
