package com.example.leetcode.CodeSample;

public class MyThread implements Runnable{
    private String title;

    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for (int x = 0; x < 10; x++){
            System.out.println(this.title+ "x=" + x);
        }
    }
}
