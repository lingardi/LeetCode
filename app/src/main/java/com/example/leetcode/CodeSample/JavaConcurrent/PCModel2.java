package com.example.leetcode.CodeSample.JavaConcurrent;

import java.util.concurrent.ArrayBlockingQueue;

import static com.example.leetcode.CodeSample.JavaConcurrent.PCModel2.arrayBlockingQueue;

/**
 * 阻塞队列实现生产者消费者模型
 */
public class PCModel2 {
    public static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10, false);

    public static void main(String[] args){
        new ProducerThread2(new Producer2()).start();
        new ProducerThread2(new Producer2()).start();
        new ProducerThread2(new Producer2()).start();
        new ConsumerThread2(new Consumer2()).start();
        new ConsumerThread2(new Consumer2()).start();
        new ConsumerThread2(new Consumer2()).start();
    }


}

class ProducerThread2 extends Thread{
    private Producer2 producer;
    public ProducerThread2(Producer2 producer){
        super();
        this.producer = producer;
    }
    @Override
    public void run() {
        while (true)
            producer.setProduct();
    }
}

class Producer2 {
    public void setProduct() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arrayBlockingQueue.offer(1);

    }
}

class ConsumerThread2 extends Thread{
    private Consumer2 consumer;

    public ConsumerThread2(Consumer2 consumer){
        super();
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true)
            consumer.getProduct();
    }
}

class Consumer2{
    public void getProduct(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            arrayBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


