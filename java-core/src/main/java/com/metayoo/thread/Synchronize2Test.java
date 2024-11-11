package com.metayoo.thread;

public class Synchronize2Test {
    private int value;
    private boolean hasValue = false;

    public synchronized void produce(int value) {
        while (hasValue) {  // 如果已有数据，等待消费者消费
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("生产者线程被中断");
            }
        }
        this.value = value;
        hasValue = true;
        System.out.println("生产了: " + value);
        notify();  // 唤醒消费者线程
    }

    public synchronized void consume() {
        while (!hasValue) {  // 如果没有数据，等待生产者生产
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("消费者线程被中断");
            }
        }
        System.out.println("消费了: " + value);
        hasValue = false;
        notify();  // 唤醒生产者线程
    }

    public static void main(String[] args) {
        Synchronize2Test synchronize2Test = new Synchronize2Test();
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                synchronize2Test.produce(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                synchronize2Test.consume();
            }
        });

        producer.start();
        consumer.start();
    }

}
