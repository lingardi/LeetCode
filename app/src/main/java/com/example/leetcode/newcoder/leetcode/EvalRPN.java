package com.example.leetcode.newcoder.leetcode;

import java.util.Stack;

/**
 * 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 * 例如：
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvalRPN {
    /**
     * 基于堆栈，操作数入栈，遇到操作符时出栈求值，将结果入栈
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens){
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                if (stack.size() < 2)
                    return 0;
                int num1 = stack.peek();
                stack.pop();
                int num2 = stack.peek();
                stack.pop();
                int res = 0;

                if (str.equals("+"))
                    res = num1 + num2;
                if (str.equals("-"))
                    res = num2 - num1;
                if (str.equals("*"))
                    res = num1 * num2;
                if (str.equals("/")){
                    if (num1 == 0)
                        return 0;
                    else
                        res = num2 / num1;
                }
                stack.push(res);
            }else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.peek();
    }
}
