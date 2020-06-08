package com.example.leetcode.newcoder.leetcode;


import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
 */
public class MaxPoints {
    /**
     *
     * 需要两重循环，第一重循环遍历起始点a，第二重循环遍历剩余点b。
     *
     *     a和b如果不重合，就可以确定一条直线。
     *
     *     对于每个点a，构建 斜率->点数 的map。
     *
     *     (1)b与a重合，以a起始的所有直线点数+1 (用dup统一相加)
     *
     *     (2)b与a不重合，a与b确定的直线点数+1
     * @param points
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int maxPoints(Point[] points) {
        if (points.length < 2)
            return points.length;

        int ans = 0;
        for (int i =0; i < points.length; i++){
            int dup = 1; //重合点
            int vtl = 0; //垂直点
            Map<Float, Integer> map = new HashMap<>();
            Point a  = points[i];
            int max = 0;
            for (int j = 0; j < points.length; j++){
                if (i == j)
                    continue;
                Point b = points[j];
                float x1 = points[i].x - points[j].x;
                float y1 = points[i].y - points[j].y;
                if (x1 == 0 && y1 == 0){
                    dup++;
                }else if (x1 == 0){
                    if (vtl == 0)
                        vtl = 2;
                    else
                        vtl++;
                    max = Math.max(vtl, max); //垂直高度的最大值
                }else {
                    float k = y1 / x1;
                    if (map.get(k) == 0)
                        map.put(k, 2);
                    else
                        map.put(k, map.get(k)+1);
                    max = Math.max(map.get(k), max); //垂直高度的最大值
                }
            }
            ans = Math.max(ans, max + dup);
        }
        return ans;
    }

    class Point {
       int x;
       int y;
       Point() { x = 0; y = 0; }
       Point(int a, int b) { x = a; y = b; }
   }
}
