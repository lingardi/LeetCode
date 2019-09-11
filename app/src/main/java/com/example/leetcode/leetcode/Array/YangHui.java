package com.example.leetcode.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>(new ArrayList<>());
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        if (numRows == 1)
            return triangle;
        for (int i = 1; i < numRows; i++){
            List<Integer> curList = new ArrayList<>();
            List<Integer> preList = triangle.get(i-1);
            curList.add(0, 1);
            if (i == 1){
                curList.add(1, 1);
                triangle.add(curList);
            }else {
                for (int j = 1; j < i + 1; j++){
                    //if不用括号又多加了一遍
                    if (j == i){
                        curList.add(j, 1);
                    }else {
                        curList.add(j, preList.get(j) + preList.get(j-1));
                    }
                }
                triangle.add(curList);
            }
        }

        return triangle;
    }
}
