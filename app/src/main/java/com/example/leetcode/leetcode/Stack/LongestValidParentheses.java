package com.example.leetcode.leetcode.Stack;

import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int max = 0;
        if (s.length() == 0)
            return max;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        //将下标压入栈中，可以获得连续下标
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else
                    max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses(")()())"));
    }
}
