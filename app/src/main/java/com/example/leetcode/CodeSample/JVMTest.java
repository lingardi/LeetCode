package com.example.leetcode.CodeSample;

public class JVMTest {
    public static void main(String[] args) {
        JVMTest inc = new JVMTest();
        int i = 0;
        inc.fermin(i);
        i= i ++;
        System.out.println(i);

    }
    void fermin(int i){
        i++;
    }
}
