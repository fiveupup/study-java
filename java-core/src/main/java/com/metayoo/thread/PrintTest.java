package com.metayoo.thread;

public class PrintTest {
    static int num = 1;
    public static void main(String[] args) {
        Object lock = new Object();
        // 打印基数
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                while (num <= 10) {
                    if (num % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + num);
                        num++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        },"thread1");

        // 打印偶数
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                while (num <= 10) {
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + num);
                        num++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
