package com.example.leetcode.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class YangHuiII {
    /**
     * 第1行为1，1
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        int pre = 1;
        //第0行为1
        cur.add(1);
        //从杨辉三角第二行开始计算
        for (int i = 1; i < rowIndex +1; i++){
            //从每一行第二位开始，第一位保持为1
            for (int j =1; j < i; j++){
                int temp = cur.get(j);
                cur.set(j, pre + temp);
                //最后一个temp仍然是1
                pre = temp;
            }
            cur.add(1);
        }
        return cur;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        int pre = 1;
        //第0行为1
        cur.add(1);
        if (rowIndex == 0)
            return cur;
        cur.add(1);
        if (rowIndex == 1)
            return cur;
        for (int i = 1; i < rowIndex; i++){
            for (int j =0; j < i+1; j++){
                if (j == 0){
                    cur.set(0, 1);
                }else {
                    int temp = cur.get(j);
                    cur.set(j, pre + temp);
                    //最后一个temp仍然是1
                    pre = temp;
                }
            }
            cur.add(1);
        }
        return cur;
    }
}
