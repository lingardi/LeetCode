package com.example.leetcode.leetcode.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {
    List<Stack<Integer>> stacks;
    int cap;
    public StackOfPlates(int cap) {
        stacks = new ArrayList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0)
            return;
        if (stacks.isEmpty()){
            stacks.add(new Stack<>());
        }
        if (stacks.get(stacks.size() - 1).size() >= cap){
            stacks.add(new Stack<>());
        }
        stacks.get(stacks.size() - 1).push(val);
    }

    public int pop() {
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).isEmpty()){
            return -1;
        }
        Stack<Integer> res = stacks.get(stacks.size() - 1);
        if (res.size() == 1){
            stacks.remove(stacks.size() - 1);
        }
        return res.pop();
    }

    public int popAt(int index) {
        if (stacks.isEmpty() || index < 0 || index > stacks.size() - 1)
            return -1;
        Stack<Integer> res = stacks.get(index);
        if (res.isEmpty())
            return -1;
        if (res.size() == 1){
            stacks.remove(index);
        }
        return res.pop();
    }
}
