package com.example.leetcode.CodeSample.JavaConcurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Synchronization {
    private ReentrantLock reentrantLock;
    private double[] accounts;
    public class Alipay{
        private Condition condition;
        public Alipay(int n, double money){
            accounts = new double[n];
            for (int i =0; i < n; i++){
                accounts[i] = money;
            }
            reentrantLock = new ReentrantLock();
            condition = reentrantLock.newCondition();
        }

        /**
         * condition管理获得锁又无法正常工作的线程，阻塞使其放弃锁
         * @param from
         * @param to
         * @param money
         * @throws InterruptedException
         */
        public void transfer(int from, int to, int money) throws InterruptedException{
            reentrantLock.lock();
            try {
                while (accounts[from] < money){
                    condition.await();
                }
                accounts[from] -= money;
                accounts[to] += money;
                condition.signalAll();
            } finally {
                reentrantLock.unlock();
            }
        }

        /**
         * 内部锁管理线程，锁中条件管理调用wait()的线程
         * @param from
         * @param to
         * @param money
         * @throws InterruptedException
         */
        public synchronized void transfer2(int from, int to, int money) throws InterruptedException{
            while (accounts[from] < money){
                wait();
            }
            accounts[from] -= money;
            accounts[to] += money;
            notifyAll();
        }
    }


}
