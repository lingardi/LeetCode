package com.example.leetcode.CodeSample.JavaConcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 中断线程：1.  Thread.currentThread().interrupted()判断标志位
 * 2. volatile boolean可见性，改变循环条件
 */

public class MyThread{
    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo,"demo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
//        thread.interrupt();
        threadDemo.cancel();

        //使用Callable方式实现多线程
        FutureTask<String> task = new FutureTask<>(new ThreadDemo2());
        new Thread(task).start();
        try {
            System.out.println("执行了吗" + task.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //线程停止执行
        Thread thread1 = new Thread(() -> {
            while (flag){
                System.out.println(Thread.currentThread().getName());
            }
        });
        Thread.sleep(1000);
        flag = false;

        //强制执行
        Thread mainThread = Thread.currentThread();
        Thread subThread = new Thread(() -> {
            for (int x = 0; x < 10; x++){
                if (x > 3) {
                    try {
                        mainThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "x=" + x);
            }
        },"子线程");
        thread.start();
        for (int x = 0; x < 10; x++){
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "x=" + x);
        }
    }
}

class ThreadDemo implements Runnable {
    private int title = 0;
    private volatile boolean on = true;

    @Override
    public void run() {
//        while (!Thread.currentThread().interrupted()){
//            title ++;
//            System.out.println(title);
//        }
        while (on) {
            title++;
            System.out.println(title);
        }
        System.out.println("stop");
//        for (int x = 0; x < 10; x++){
//            System.out.println(this.title+ "x=" + x);
//        }
    }

    public void cancel() {
        on = false;
    }
}
    class ThreadDemo2 implements Callable<String> {
        private int title = 0;
        private volatile boolean on = true;
        //线程执行完后回调此方法
        @Override
        public String call() throws Exception {
            for (int x = 0; x < 10; x++){
            System.out.println(this.title+ "x=" + x);
             }
            return "ok";
        }
    }