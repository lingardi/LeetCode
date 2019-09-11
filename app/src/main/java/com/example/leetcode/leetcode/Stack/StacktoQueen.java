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
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack1.isEmpty())
            return stack1.pop();
        throw new RuntimeException("kong");
    }

    /** Get the front element. */
    public int peek() {
        if (!stack1.isEmpty())
            return stack1.peek();
        throw new RuntimeException("kong");
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
