package com.example.leetcode.CodeSample.JavaConcurrent;

import java.util.concurrent.ArrayBlockingQueue;

import static com.example.leetcode.CodeSample.JavaConcurrent.PCModel.FULL;
import static com.example.leetcode.CodeSample.JavaConcurrent.PCModel.count;
//import static com.example.leetcode.CodeSample.JavaConcurrent.PCModel.lock;

/**
 * 1. 单个消费者生产者，必须是同一把锁（公共缓冲区），可用if、notify()满足需求
 * 2. 多个消费者生产者，需替换为while、notifyAll()避免假死，也可以使用标志位判断缓冲区满/空
 */

public class PCModel {
    public static Integer count = 0;
    public static final Integer FULL = 10;
    private static String lock = "lock";
//    public static String lock = "lock";
    public static void main(String[] args){
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        ProducerThread producerThread = new ProducerThread(producer);
        ConsumerThread consumerThread = new ConsumerThread(consumer);
        producerThread.start();
        consumerThread.start();
        new ProducerThread(new Producer(lock)).start();
        new ProducerThread(new Producer(lock)).start();
        new ConsumerThread(new Consumer(lock)).start();
        new ConsumerThread(new Consumer(lock)).start();

    }
}

class ProducerThread extends Thread{
    private Producer producer;
    public ProducerThread(Producer producer){
        super();
        this.producer = producer;
    }
    @Override
    public void run() {
        while (true)
            producer.setProduct();
    }
}

class Producer {
    private String lock;

    public Producer(String lock) {
        this.lock = lock;
    }


    public void setProduct() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            while (count.equals(FULL)) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
            lock.notifyAll();
        }
    }
}

 class ConsumerThread extends Thread{
    private Consumer consumer;

    public ConsumerThread(Consumer consumer){
        super();
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true)
            consumer.getProduct();
    }
}

 class Consumer{
    private String lock;

    public Consumer(String lock){
        this.lock = lock;
    }

    public void getProduct(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            while (count == 0){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count --;
            System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
            lock.notifyAll();
        }
    }
}