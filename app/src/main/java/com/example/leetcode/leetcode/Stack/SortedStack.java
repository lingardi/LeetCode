package com.example.leetcode.leetcode.Stack;

import java.util.Stack;

public class SortedStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public SortedStack() {

    }

    public void push(int val) {
        while (! stack1.isEmpty()) {
            if(stack1.peek() < val) {
                stack2.push(stack1.pop());
            }else {
                break;
            }
        }
        stack1.push(val);
        while (! stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

    }

    public void pop() {
        if (!stack1.isEmpty()){
            stack1.pop();
        }
    }

    public int peek() {
        return stack1.isEmpty()? -1 : stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
