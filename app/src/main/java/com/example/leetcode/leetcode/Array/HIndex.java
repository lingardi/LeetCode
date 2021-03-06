package com.example.leetcode.leetcode.Array;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）
 * 至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 *
 * 示例:
 *
 * 输入: citations = [3,0,6,1,5]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 *
 * 说明: 如果 h 有多种可能的值，h 指数是其中最大的那个。
 */
public class HIndex {
    /**
     * 1、首先看到h个元素大于等于某个值，N-h个元素小于等于某个值，这显然是一个有序序列的特征，
     *    所以自然而然的想到先将数组排序；
     *
     * 2、将数组排序之后，对于给定的某个i，我们知道有citations.length - i篇论文的引用数 ≥ citations[i]，i篇
     *    论文的引用数 ≤ citations[i]；
     *
     * 3、不妨设h = citations.length - i，即至多有h篇论文分别引用了至少citation[i]次，其余citations.length - h篇
     *    论文的引用数不多于citation[i]次。
     *
     *    既然如此，只要citation[i] ≥ h，就满足题意。
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int i = 0;
        for (; i < citations.length; i++){
            int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }
}
