package com.example.leetcode.leetcode.Stack;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    private Stack<Integer> stack;
    private Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if (min.isEmpty() || min.peek() > x)
            min.push(x);
        stack.push(x);
    }

    public void pop() {
        if (!stack.isEmpty() || !min.isEmpty())
            if (stack.peek().equals(min.peek()))
                min.pop();
            stack.pop();
    }

    public int top(){
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");

    }

    public int getMin() {
        if (!min.isEmpty())
            return min.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
