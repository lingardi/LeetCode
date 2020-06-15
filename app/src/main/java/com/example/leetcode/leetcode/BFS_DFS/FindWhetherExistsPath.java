package com.example.leetcode.leetcode.BFS_DFS;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 * 示例2:
 *
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 * 提示：
 *
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 */
public class FindWhetherExistsPath {
    /**
     * 先建立邻接表，再bfs或dfs
     * @param n
     * @param graph
     * @param start
     * @param target
     * @return
     */
    //使用深度优先搜索搜索可行路径
    private boolean search(List<Integer>[] graph, int start, int target, boolean[] marked){
        if(start == target)
            return true;

        marked[start] = true;
        for(int next : graph[start]){
            if (marked[next])
                continue;
            //如果找到通路，　返回true
            if(search(graph, next, target, marked))
                return true;
        }
        return false;
    }

    //使用邻接表形式表示图
    private List<Integer>[] constructGraph(int n, int[][] graph){
        List<Integer>[] graphList = (LinkedList<Integer>[])new LinkedList[n];
        for(int i = 0; i < n; i++)
            graphList[i] = new LinkedList<>();

        for(int i = 0; i < graph.length; i++){
            graphList[graph[i][0]].add(graph[i][1]);
        }
        return graphList;
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] graphList = constructGraph(n, graph);
        boolean[] marked = new boolean[n];
        return search(graphList, start, target, marked);
    }
}
