package com.example.leetcode.leetcode.Array.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[][]{};
        if (intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        Map<String, Integer> range = new HashMap<>();
        range.put("low", intervals[0][0]);
        range.put("high", intervals[0][1]);
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > range.get("high")){
                int[] res = new int[]{range.get("low"), range.get("high")};
                list.add(res);
                range.put("low", intervals[i][0]);
                range.put("high", intervals[i][1]);

            }else {
                if (intervals[i][1] > range.get("high"))
                    range.put("high", intervals[i][1]);
            }



            if (i == intervals.length - 1){
                int[] res0 = new int[]{range.get("low"), range.get("high")};
                list.add(res0);
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i=0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args){
        merge(new int[][]{{1,4},{0,5}});
    }

}
