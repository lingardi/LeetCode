package com.example.leetcode.newcoder.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        return isBST(sequence, 0, sequence.length -1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if (start >= end){
            return true;
        }
        int val = sequence[end];
        int i = start;
        for (i = start; i < end; i++){
            if (sequence[i] > val)
                break;
        }

        for (int j =i; j < end; j++){
            if (sequence[j] <= val)
                return false;
        }

        return isBST(sequence, start, i -1)&&isBST(sequence, i, end - 1);
    }
}
