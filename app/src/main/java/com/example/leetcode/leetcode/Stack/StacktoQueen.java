package com.example.leetcode.leetcode.Stack;

import java.util.Stack;

public class StacktoQueen {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StacktoQueen() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue.
     * 两个栈，保证插入的元素在栈底，FIFO
     *
     */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty())
            return stack2.peek();
        throw new RuntimeException("");
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
