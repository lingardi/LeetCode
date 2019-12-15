package com.example.leetcode.newcoder.offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        if (stack2.isEmpty()){
            stack2.push(node);
        }else {
            if (node < stack2.peek()){
                stack2.push(node);
            }else {
                stack2.push(stack2.peek());
            }
        }
        stack1.push(node);
    }

    public void pop() {
        if (!stack1.isEmpty()){
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        if (!stack1.isEmpty())
            return stack1.peek();
        else
            throw new RuntimeException();
    }

    public int min() {
        if (!stack2.isEmpty())
            return stack2.peek();
        else
            throw new RuntimeException();
    }
}
